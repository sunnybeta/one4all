# Simple Storage Service

- Simple storage service focused on general object storage
- Stores all kinds of files
- Scalable, Highly Available, Durable, Supports Integration with AWS
- Useful in Website Hosting, Database Backups, Data Procesing Pipeline

### Buckets & Objects

- A *bucket* is a container of objects you want to store in a certain namespace
- Bucket names are globally unique across all regions within a partition
- Objects are files which you store in a bucket
- Maximum size of an object is 5TB
- URL: *http://s3.amazonaws.com/bucketname/objectname* -> Only works if bucket is public

### S3 Storage Class

- Allow users to reduce costs but within certain sacrifices: availability

**Standard**: Default, Excellent Availbility, Low Latency

**Intelligent**: Shuffles around data based on access automatically

**Infrequent Access**: Older stuff rarely accessed but when done requires high level of latency

**Glacier**: Archiving Use Case, Minutes to Hours

- We can move out data to different storage classes with *Lifecycle Rules*

Example: Standard Tier (Hot Data) -> Infrequent Access -> Glacier (Cold Data)

### Lifecycle Rules

Coming Soon.

### Security

**Publicity** Make sure public access is blocked by default

**Data Protection** Highly Durable & Availble Guarantees, encryption in transit and rest

**Access** Manage access and resource based controls with AWS IAM

**Auditing** Access Logs, Action Based Logs, Alarms

**Infrastructure Security** Built on top of AWS Cloud Infastructure

### Bonus

**Data Ingestion Pipeline**

*Stock Market Data -> Amazon Kinesis Data Firehose -> Add data to S3 when batch data equals 5MB*

Now we can invoke a lambda function which processes the data in S3


**Analytics & Dashboarding**

Amazon Athena -> S3 -> Amazon Quick Sight

**Event Driven Architectures**

Suppose customer uploads an image to S3 bucket, setup an S3 event which triggers a lambda function which notifies the customer with AWS AppSync.

### Pricing

- Dependent on storage classess
- Three Main Factors: Storage, Accesss, Transfer
