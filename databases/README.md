# Database Theory

## ACID Transaction

ACID is a set of guiding principles that ensure database transactions are processed reliably.

### Tranaction

A *transaction* is collection of queries or one unit of work. Example: Account Deposit (`SELECT`, `UPDATE`, `DELETE`)

### Atomicity

*Atomicity* states that all transactions must succeed. If one query fails, all queries should rollback and database must go back to its prior state.

### Consistency

*Consistency* states that a change must maintain integrity or should be
cancelled completely in data and reads.
Eventual consistency is what databases aim for in case of replicas.

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


## B+ Trees

## Sharding
