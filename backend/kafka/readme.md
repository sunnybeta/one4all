# Kafka

Kafka is a distributed event-store and a stream processing platform. 

## Features

It is designed for large throughput and is designed for moving large number of records in a short amount of time. Kafka uses an append-only log as its primary data structure which is a sequential data access pattern as it is faster than random data access pattens. Moreover, it uses zero-copy system which sends a page of data efficiently from the disk to the consumer.



## Producers & Consumers

The process which reads these updates and writes them to a queue is called a *producer*.

The downstream processes that consume / process these updates is called a *consumer*.

## Example

### Problem

Design a system which listens to various football game updates from various sources collecting information. This information then has to be displayed to several kinds of devices such as mobiles and desktop browsers. We also have producers and consumers setup which read the updates, push then to a queue and send these updates to the devices.

If we want to expand and listen to more games, our servers will have a difficult time handling the excess load. Similarly our consumers will struggle as well.

What do we do?

### Solution

We can setup multiple queues and distribute the contents on multiple queues. Kafka requires a *distribution strategy* for distributing events over multiple queues.

## Distributed Queue

In case of distributed queues, each one of the queue is called a *partition*.

The total number of partitions is called a *partiion count*.

Each server holding one or more partitions is called a *broker*.

Each item in a partition is called a *record*.

The field used to decide which partition the record should be stored in is called a *partition key*. If no key is specified, Kafka presumes a random partition.

A grouping of partitions handling the same kind of data is called a *topic*.

To identify each record in a topic uniquely, Kafka provides a sequential number to each record called an *offset*. A record can be identified by a partition number and an offset.

We can now have multiple consumers as well combined as *consumer groups*, with each consumer having its own offset pointer.

## Retention

Kafka provides various policies which can clean up records. For example, we can maintain a record age limit of 24 hours so that all events older than 24 hours are deleted.

Records can also be stored in consistent storage so that events are not lost and can be replayed and recovered.

## Replication

Kafka also replicates partitions so that if a partition goes down, a back up partition can take over for processing to resume. The number of replicated partitions can be configured by setting the *repliaction factor*.

## Zero-Copy System

### No Zero-Copy System

- Data is loaded from disk to OS cache
- Data is copied from OS cache into Kafka application
- Data is copied from Kafka to Socket Buffer
- Data is copied from Socket Buffer into NIC Buffer
- Finally, data is sent over the netwoek to the consumer

### Zero-Copy System

- Data is loaded from disk to OS cache
- Data is copied from OS cache to NIC buffer using DMA using the `sendFile` system call. (With DMA, CPU is not involved making the process more efficient.)
