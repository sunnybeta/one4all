# System Design Fundamentals

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

## CDN

A *CDN (Content Delivery Network)* brings content closer to the user as
performance is critical to user engagement and retention. 

To achieve this CDNs, deploy hundreds of servers all over the world. They are
called PoP (Point of Presence) and the server inside them are called
*Edge Server*. Each edge server acts as a reverse proxy with huge content cache.

If a piece of content is in the cache, it can be quickly returned the user.

All TLS connections terminate at the edge server which significanyl decreases
the latency for the user.

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

