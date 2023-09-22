# Microservices

**CONTENTS**

* [Distirbuted Systems](#distributed-systems)
* [API Gateway](#api-gateway)
* [Messaging Guarantees](#messaging-guarantees)


## Distributed Systems

A distributed system is a system of components which are located on different networked computers communicating with each other via passing messages to one another or over a central componenet(s).


## API Gateway

An API gateway is an API management tool that sits between a client and a collection of backend services. The API gateway intercepts all incoming requests and sends them through the API management system. It acts as a *reverse proxy to accept all API calls, aggregate the various services required to fulfull them, and return the appropriate results.

- Protect your APIs from overuse and abuse by using authentication service and rate limiting.
- Add analytics and moniroting tools to figure out how your APIs are being used
- Manage distinct calls in case of microservice architecture

## Messaging Guarantees

*If we send a message to a user, how do we ensure that the user receive it?*

If message is received, keep some retry logic in the system so that we can guarantee that the message will reach the second client.

*How do we ensure ordered delivery?*

We can keep 100 message queues and index them from 0 to 99. Store the message in the queue number `user_id % 100`. We can apply consistent hashing as well to this queue so that one queue does nto get overloaded.

*How do avoid duplication on retries? Idempotancy*

The message ID will remain the same. Client can have a store regarding the recceived message or the queue can keep a store of sent messages and avoid sending the message if the ID matches.
