# Proximity Service

*Proximity Service* is commonly found as abackend component to find closest business locations like restaurants or gas stations in Yelp and Google Maps.

## Problem

### Functional Requirements

1. Given a user's location and a search radius, return all the businesses locations.
2. Business owner can add, delete and update a business.
3. User can view detailed information about a business.

### Non-Functional Requirements

1. Latency shoulde be low
2. Highly available service. Handle traffic spikes during peak hours.

### Calculations

* 100 million DAUs
* 200 million businesses

Assume there are 5 search queries per DAU which equals approximately 500 milliion queries.

Number of search queries per second `500_000_000 / 100_000` ~ 5000 qps`

Storage do we need for 200 million businesses: `200_000_000 * 1 KB = 200 GB`

Storage for goespatial data: `200_000_000 * 8 * 3 = ~5 GB`

## API Design

### Search API

`GET /v1/businesses`

| Query Parameters |         Type           |      Description           |
|   :---:          |         :---:          |         :---:              |
| latitude         | `double`               | latitude of user location  |
| longitude        | `double`               | londigude of user location |
| radius           | `Optional[int] = 5000` | Search Radius              |
| limit            | `Optional[int] = 10`   | Page Size                  |
| skip             | `Optional[int] = 1`    | Page Number                |

```json
{
    "count": 10,
    "data": {
        "business": [BusinessObject1, BusinessObject2, ...]
    }
    "pagination": {
        "page_size": 10,
        "page_number": 2,
    }
}
```

### Business API

`GET    /v1/businesses/:id`

`POST   /v1/business`

`PUT    /v1/business/:id`

`DELETE /v1/business/:id`


## Schema

### business

- id PK
- name
- address
- city
- state
- country
- latitude
- longitude

### geospatial index

- business_id PK FK
- location


## Services

### Load Balancer

Distributes incoming requests across two services based on API routes.

### Location Search Service

* Read Heavy with No Write Requests
* High QPS ~5000
* Service is stateless and should be easy to scale horizontally


### Business Service

* Manages the CRUD request for business objects
* QPS is not for reads high. Changes don't need to take affect right away.
* Great candidate for caching

 o        +-------------+       +-----------------------+
-|- ----> |LOAD BALANCER| ----> |Location Search Service| 
/|\       +-------------+       +-----------------------+
                 |
                 |
                 |
                 V
         +----------------+
         |Business Service|
         +----------------+

## Database

### Observations

- Services are read heavy
- Writes don't need to be immediate
- Read QPS is much higher than the write QPS

Our database cluster should consist of a primary-seconday setup. The primary database handles all the write requests while the secondary databases must handle all the read requests.

### Geo Spatial Database

We should use database optimized for geo-spatial queries like Redis GeoHash or PostgreSQL with PostGIS extension.

If we create a circle or a bounding box and check for businesses within it, this requires a complete table scan and is highly inefficient. 

We need to map two dimensional map data into a single dimensionsl data so that we can put an index on it.

#### Hash Based Implementation

GeoHash works by first dividing the world map into 4 quadrants and assigning it the bit strings: `00`,`01`,`10`,`11`. These quadrants are futher divided into 4 qudarants and the new bit strings are appended. We continue this process until the smallest quadrant size has been reached. Instead of representing the region with a long bit string, we encode the stringin base32 string.

The base32 encoded string length determines the size of the grid.

If two geohash strings share a long prefix, they should ideally be close to each other, but this is not alawys the case. To solve this, we consider the 8 neighbouring geohashes which can be calculated in constant time.

#### Tree Based Implementation

Coming Soon.

#### Fields

The geospatial database will now have a compund key `(geohash, business_id)` as one multiple business ID's can belong in the same goehash. This also makes the removal of a business ID from the table easier.

#### Scaling

The entire database including the geohash can fit in `~ 6 GB` of memory. Since the QPS is high, we can have replicas of our table for decreasing the load. Sharding is too complicated for this purpose.

## Caching

* Do we need a caching layer?

For our Business API, since it is read heavy we can put a caching layer in front for frequently access data.

The service is not write heavy and we are looking for eventual consistency, so a single database structure will be enough.

As we scale and the product grows, we can shard our database.

## Life Cycle

- User tries to find a restaurant within 500 m.
- Client sends the request to the load balancer
- Load balancer forwards teh request to the location based service.

`GET /v1/businesses?limit=10&skip=1&latitude=0.412&longitude=3.331&radius=500`

- The service finds the geohash precision that matches the search request. 6
- Service calculates the neighbouring geohashes
- The service requests the database for the business IDs along with the latitude and longitude pairs.
- Finally, the service calculates the distances between the user and the businesses, ranks them and returns the results.

