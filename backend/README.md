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

## OSI Model

## TCP

## UDP

## DNS

## Load Balancing

The mechanism by which we distribute requests (load) from clients on to the
servers so as to not overload a few servers is known as *load balancing*.

*How do we decide which request is served by which server?*

We will need a hash function `h(r)` which takes a request ID, hashes it and
computes the modulo `M` to map this request to one of the servers (numbered
from `0..N`. Since the servers themselves have IDs, we can compute their
hashes as well modulo M. 

**NOTE**: Requests ID are rarely random as they contain some information about the user as well. This can be used to cache and respond to requests faster.


## Consistent Hashing

*How do we handle a request?*

Whenever a request is received, 
- compute the hash
- go clockwise in you search space `0..M-1`
- select the fist server

This works because hashes are uniformly random so that the distance between them is uniform and thus the load across the servers is uniform.

Expected Load Factor: `1/N`

*What if we add a new server?*

If we add a new server, then we can follow the above algorithm to figure out
which requests will be processed by the new server. The change in request
handing will be much less.

*What if a server goes down?*

Then, all the requests will now have to be served by the next server.
This is not balanced. The algo works well theoretically. It works pratically if
you have loads of servers.

To solve this, we can create virtual servers by having *multiple hash
functions*, say `K`, to compute multiple hashes of the servers. Now we, in some
sense have, `N*K` servers. Choosing an appropriate `K` value `log(N)` can almost
neglect the effect of removing a server because now the loads can be picked up
by other servers as well and not shifting the entire burden onto one server.


## CAP Theorem

**Conistency**: Ensuring that all clients see the same data at the same time

**Availability**: Ability of a system to respond to requests

**Partition Tolerance**: Ability of a system to operate if there is a network
partition (for example, due to network failures)

If a partition happens, the system must choose betwween *consistency* and
*availbility*. If the system prioritises consistency, it may become unavailble
until the partition is resolved. If the system prioritises availability, it may
allow updates to the data resulting in data inconsistencies.

**Consistency, Availbility & Partition Tolerance cannot be supported at the same
time by a distributed system.**

In real world, there is a degree of availbility and consistency which has to be
kept in mind before designing a distributed system.

## Content Delivery Network

A *CDN (Content Delivery Network)* brings content closer to the user as
performance is critical to user engagement and retention. 

To achieve this CDNs, deploy hundreds of servers all over the world. They are
called PoP (Point of Presence) and the server inside them are called
*Edge Server*. Each edge server acts as a reverse proxy with huge content cache.

If a piece of content is in the cache, it can be quickly returned the user.

All TLS connections terminate at the edge server which significanyl decreases
the latency for the user.


## Distributed Systems

A distributed system is a system of components which are located on different networked computers communicating with each other via passing messages to one another or over a central componenet(s).


## API Gateway

An API gateway is an API management tool that sits between a client and a collection of backend services. The API gateway intercepts all incoming requests and sends them through the API management system. It acts as a *reverse proxy to accept all API calls, aggregate the various services required to fulfull them, and return the appropriate results.

- Protect your APIs from overuse and abuse by using authentication service and rate limiting
- Receive a general request, manipulate and validate the request in peculiar ways depending on the microservce requirements
- Add analytics and moniroting tools to figure out how your APIs are being used
- Manage routing of distinct calls in case of microservice architecture
- Load Balancing the incoming requests

API Gateways can scale horizontally.

## Messaging Guarantees

*If we send a message to a user, how do we ensure that the user receive it?*

If message is received, keep some retry logic in the system so that we can guarantee that the message will reach the second client.

*How do we ensure ordered delivery?*

We can keep 100 message queues and index them from 0 to 99. Store the message in the queue number `user_id % 100`. We can apply consistent hashing as well to this queue so that one queue does nto get overloaded.

*How do avoid duplication on retries? Idempotancy*

The message ID will remain the same. Client can have a store regarding the recceived message or the queue can keep a store of sent messages and avoid sending the message if the ID matches.


## PACLEC Theorem
Coming Soon.

## Caching
Coming Soon.

## Latency
Coming Soon.

## Resilience
Coming Soon.

## Reverse Proxy & NGINX
Coming Soon.

## Long Polling
Coming Soon.

## Web Sockets 
Coming Soon.

## Server Side Events
Coming Soon.

## Kafka
Coming Soon.

## Read / Write Ratio
Coming Soon.


