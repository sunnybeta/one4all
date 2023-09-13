# Amazon Web Services

## S3

- Simple storage service focused on general object storage
- Stores all kinds of files
- Scalable, Highly Available, Durable, Supports Integration with AWS
- Useful in Website Hosting, Database Backups, Data Procesing Pipeline

### Bucket & Objects

- A bucket is a container of objects you want to store in a certain namespace
- Bucket names are globally unique across all regions within a partition
- Objects are files which you store in a bucket
- Maximum size of an object is 5TB
- Url: http://s3.amazonaws.com/bucketname/objectname -> Only works if bucket is public

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

- Make sure public access is blocked by default
- Data Protection - Highly Durable & Availble Guarantees, encryption in transit and rest
- Access - Manage access and resource based controls with AWS IAM
- Auditing - Access Logs, Action Based Logs, Alarms
- Infrastructure Security - Built on top of AWS Cloud Infastructure

### Bonus

**Data Ingestion Pipeline**
*Stock Market Data -> Amazon Kinesis Data Firehose -> Add data to S3 when batch data equals 5MB*
* Now we can invoke a lambda function which processes the data in S3


**Analytics & Dashboarding**
* Amazon Athena -> S3 -> Amazon Quick Sight

**Event Driven Architectures**
* Suppose customer uploads an image to S3 bucket, setup an S3 event which triggers a lambda function -> Notify the customer with AWS AppSync

### Pricing

- Dependent on storage classess
- Three Main Factors: Storage, Accesss, Transfer

## Lambda

- AWS Lambda is a compute service
- We can run code at scae without worrying about servers
- We write functions - the primary unit of lambda
- Useful in API Hosting, Event Processing an Timer Based Jobs

### Workflow

1. Create a function
2. Write and upload your code in a supported programming language
3. Run your function

### Why is it uesful?

- No servers to manage
- Autoscaling
- Pay for what you use
- Performance; tune lambda by adding extra memory
- Service integrations
- Easy to use, monitor and debug

### Disadvantages

- Gain flexibility at the expense of control. We lose low level details of your infrastructure

### Function Execution

1. Code download: Full Cold Start
2. Start Execution Environment: Full Cold Start
3. Execution init code: Partial Cold Start
4. Execute handler code: Warm Start

### Strategies to Minimize Cold Start

- Minimize number of library dependency
- Only import what you need
- Raise memory configuration
- Utilize provisioned concurrency: Keeps code in warm stage and ready to go


## IAM
Coming Soon.
