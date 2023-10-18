# Backend

## Frameworks

1. [FastAPI](fastapi)
2. [ExpressJS](express)
3. [Spring](spring)
4. [Gin](gin)



## REST

**RE**presentational **S**tate **T**ransfer is an architectural style for developing web services. REST is popular due to its simplicity and the fact that it builds upon existing systems and features of the internet's Hypertext Transfer Protocol (HTTP) in order to achieve its objectives, as opposed to creating new standards, frameworks and technologies.

## HTTP Methods

The methods mentioned below are from my research and understanding. The definitions and usage can differ in real world APIs.

### GET

Used for retrieving a resource from the server.

`GET /users/:id`

### POST

Used for creating a resource on the server.

`POST /users`

### PUT

Used for updating a resource completely. Creates the resource and returns `201` if the resource does not exist. Should be idempotent.

`PUT /users/:id`


### PATCH

Used for updating a resource partially. Returns a `404` if the resource does not exist.

`PATCH /users/:id`


### DELETE

Deletes the resource from the server. Returns a `202` or `204`.

`DELETE /users/:id`


## Status Codes

| Status Code |                              Description                                    |
|   :---:     |                                 :---:                                       |
|    200      | OK - Everything went well; Response is accepted                             |
|    201      | CREATED - Object was created successfully                                   |
|    202      | ACCEPTED - Your request is cool with our servers                            |
|    204      | NO CONTENT - We accept your request and that's that good bye                |
|    301      | MOVED PERMANENTLY - We are no longer here and will never be                 |
|    302      | MOVED TEMPORARILY - We are here only for a some time                        |
|    400      | BAD REQUEST - Cannot Process this request                                   |
|    401      | UNAUTHORIZED - I don't know who you are                                     |
|    403      | FORBIDDEN - I know who you are but can't do that                            |
|    404      | NOT FOUND - Resource asked for was not found                                |
|    405      | METHOD NOT ALLOWED - This endpoints does not have the method implemented    |
|    406      | NOT ACCEPTABLE - The resource is available but not in the format you desire |
|    409      | CONFLICT - Collision Detected                                               |
|    418      | I AM A TEAPOT :>                                                            |
|    500      | INTERNAL SERVER ERROR : Server is not running                               |
|    502      | BAD GATEWAY - Cannot re route request                                       |
|    503      | SERVICE UNAVAILABLE - Service is down                                       |
|    504      | GATEWAY TIMEOUT - Waited too long for a response                            |

## Object Relation Model

ORM is a bridge between data representations from different resources.

#### Pros

* Developer does not have to worry about DB connections and queries as they are handled by the ORM itself.
* Type safety and conversions are automatically managed.
* Easier to write code without understanding the underlying queries
* Errors due to absurd or incorrect queries can be easily debugged and/or avoided.
* Complex queries are easilty managed and can be built programatically.

#### Cons

* Complex queries are slower than direct DB queries.
* One must consider the number of round trips to the server the ORM makes to the server.


## Javascript vs Typescript

|       JS          |              TS               |
|      :---:        |             :---:             |
| dynamically typed | statically typed              |
| prototype based   | class based                   |
| no interfaces     | supports interfaces           |
| hard to debug     | types checked at compile time |
| cannot run TS     | backward compatible with JS   |


