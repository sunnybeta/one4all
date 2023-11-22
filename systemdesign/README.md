# System Design

### Contents

1. [Proximity Service](proximity)
2. [Chat Application](whatsapp)

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

## Caching

Caching is mechanism used to enhance performance and response time which
provides a backup fast access rather than reading from slow storage.

### Types of Cache

#### L1
Smallest and fastest cache integrated in the CPU itself which stores
frequenctly accessed data and instructions allowing the CPU to quickly access
them without having to fetch them from slower memory.

#### L2
L2 cache is larger and slower than L1 typically embedded on the CPU.

#### L3
L3 cache is even larger than  L2 and is often shared between multiple CPU cores

#### Transalation Lookaside Buffer (TLB)
TLB stores virtual to physical address translations and is used by the CPU to
quickly translate virutal memory address to physical memory address reducing
the time taken to access data from memory.

#### Page

Page cache is used by the operating system to access blocks of data in memory.
When a program requests some data, the OS can quickly retrieve it from memory
instead of reading it from the disk.

#### Inode Cache

Incode cache is used by the operating system to speed up file system operations
by reducing the number of disk access required to access files and directories.

#### HTTP Cache

On the applicationfront end, web browsers can cache HTTP responses to enable
faster retrieval of data. First time the response is returned with an
expiration policy in the HTTP header. If we request this data again, we will
return the data from cache if available.

#### Load Balancer Cache

Some load balancers can cache ressources to reduce the load on the backend
servers.

#### Not Always In-Memory Cache

- Message brokers like Kafka cache loads of messages on disk for long periods
of time bsaed on retention policy.
- Distributed caches such as redis can store key value paris in memory
providing higher read-wrte performance.
- Elastic search can index data for log search and document search providing
quick and effieicny access.
- In databases, the data is written in a write-ahead log before being indexed
in a B-tree. The buffer pool is a mempry area for saving qurey results.
Materialized views can precompute results for faster performance.

### Backend Cache

#### Spatial Cache

When we retrieve data from a disk to pull a certain block of data, we might as
well retrieve the nearby blocks so that if future requests require these blocks
we can avoid another disk read.

#### Temporal Cache

When we retreive a piece of data again and again, this latest piece of data
might be very important and will be ranked higher among other data points which
are cached. Least Recently Used cache (LRU) is such an example.

#### Distributed Cache

For distributed caching, we need to keep the cache in sync with the main data
source. This is the hardest problem in backend engineering.

##### Write-Through Cache

* Update the cache first and then update the disk
* Update the database and cache both at the same time.
* Update the cache first and then the cache updates the database.

Now when we query for some data, we can guarantee that the cache will have the
latest data.

##### Write-Back Cache

* Write to the cache and then its the duty of the cache store to update the
disk asynchornously. The idea isat regular intervals we take all this data in
batches and update the disk.

It is difficult guarantee persistence. We lost the Durability from ACID properties.



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
