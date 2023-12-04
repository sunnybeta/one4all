# Database Theory

## ACID

ACID is a set of guiding principles that ensure database transactions are processed reliably.

### Transaction

A *transaction* is collection of queries or one unit of work. Example: Account Deposit (`SELECT`, `UPDATE`, `DELETE`)

### Atomicity

*Atomicity* states that all transactions must succeed. If one query fails, all queries should rollback and database must go back to its prior state.

### Consistency

*Consistency* states that a change must maintain integrity or should be cancelled completely in data and reads. Eventual consistency is what databases aim for in case of replicas.

### Isolation

*Isolation* is the property that any read or write will not be impacted by other reads or writes of separate transactions.

* **Read uncommitted** No isolation, any change from outside is visible to the transactions
* **Read committed** Each query in a transaction only sees committed stuff
* **Repeatable Read** Each query in a transaction only sees committed updaes at the beginning of a transaction.
* **Serializable** Transactions are serialised

### Durability

Committed transactions must be perissted in a durable non-volatile storage.

Successful commits will survive permanently.

## Indexing

An *index* is a small referential table that holds the row references against the index query.

One can think of an index like a two column table sorted by the index value along with an ID.

If we filter our records on some field, the database engine iterates over all the rows, read the required records, and checks if the particular row matches our criteria. If we have an index, we can read the index and create buffer which stores the required row IDs. Finally, we would like to get the relevant row data with this list of IDs.

You may not need to iterate the entire index if you use *multilevel* indices.

## Sharding

Sharding is a method of horizontally partitiong a database into multiple database servers. Horizontal partitioing is the process of dividing a database based on a single key from the database fields.

- Joining tends to be a problem if you have to join tables across different databases. 
- One must take care of the shard being flexible.

To make the shards more dynamic, we can further shard the already sharded database on some criteria into mini-shards. This is also known as heirarchcial sharding. There is a shard manager which will take care of which minishard should be handling a query. Once the sharding is complete, we can now add indicies on the mini-shard to speed up the queries.

To deal with outages on a shard, we can consider implementing a leader / follower architecture where the write happens only on the master database while the reads are distributed among the follower databases. If the leader fails, the follower databases can choose one master among themselvers.

**Pros**

- Handle large reads and writes
- Increase overall storage capacity
- Higher availability

**Cons**

- Operationally complex
- Cross Shard Queries

## Database Internal

A database has two components:

- **Storage Engine** Storage, Indexes, Data Files, Transactions
- **Front End** API & Data Format
