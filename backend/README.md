# Backend


## Miscellaneous


### OpenAPI Specification

The Open API Specification (OAS) is an industry standard, language-agnostic interface to HTTP APIs which allows both developers and the computers to understand the API services and definitions completely without access to the source code.

### Javascript vs Typescript

| JS | TS |
| :---: | :---: |
|dynamically typed | statically typed |
| prototype based | class based |
| no interfaces | supports interfaces |
| hard to debug | types checked at compile time |
| cannot run TS | backward compatible with JS | 


### Object Relation Model

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

