# System Design Fundamentals

## DNS

## Load Balancer

## Consistent Hashing

## CAP Theorem

Consistency, Availbility & Partition Tolerance: All three cannot be supported at the same time by a distributed system.

## Caching

## Latency

## Resilience

## Reverse Proxy & NGINX

## Long Polling

## Web Sockets 

## Server Side Events

## Kafka

## Read / Write Ratio

## CDN

A *CDN (Content Delivery Network)* brings content closer to the user as performance is critical to user engagement and retention. 

To achieve this CDNs, deploy hundreds of servers all over the world. They are called PoP (Point of Presence) and the server inside them are called *Edge Server*. Each edge server acts as a reverse proxy with huge content cache.

If a piece of content is in the cache, it can be quickly returned the user.

All TLS connections terminate at the edge server which significanyl decreases the latency for the user.

