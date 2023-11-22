# Identity and Access Management

- **Resources** are the entities you create in AWS: Lambda Fucntions, S3 Buckets,
DynamoDB Instances.

- **IAM** is a core AWS service that helps you control access to
resources on AWS.

- Users performace **actions** on resources like creating, upating or deleting
resources. The permission required to perform an actions is provided via a
**Policy**.

### Implicit and Explicit Deny

**Implicit Deny**: If a user has not been given permissions to perform cretain
actions, he has been implicitly denied to perform the action.

**Explicit Deny**: If a user has not been denied permissions to perform cretain
actions, by specifying `"Effect": "Deny"`.

### Access Key & Secret Access Key

Access Key and Secret Access Key are alphanumeric string which uniquely
identifies who you are on AWS.

### Policy Statment

#### Create Bucket Permission

```json
{
    "Verison": "2023-09-14",
    "Statement": [
        {
            "Sid": "CreateS3",
            "Effect": "Allow",
            "Action": [
                "s3:CreateBucket",
            ],
            "Resource": "*",
        }
    ]
}
```

#### DynamoDB Table Read Only Access to Specific Columns

```json
{
    "Verison": "2023-09-14",
    "Statement": [
            {
                "Sid": "ReadOnlyAccexs",
                "Effect": "Allow",
                "Action": [
                    "dynamodb:BatchGet*",
                    "dynamodb:GetItem",
                    "dynamodb:Query"
                ],
                "Resource": "arn:aws:dynamodb:*:*:table/TestTable",
                "Condition": {
                    "ForAllValues:StringEquals": {
                        "dynamobd:Attributes": [
                            "column-name",
                        ]
                },
                "StringEqualsIfExists": {"dynamoddb:Select": "SPECIFIC_ATTRIBUTES"}
            }
        }
    ]
}
```

### Groups, Roles & Trust Relationship

#### Groups
You can create groups for aws managers and then assign default policy document.
One or more users can be added in a group and the corresponding policy document
will be assigned to them. This can speed up permission process and reduce the
timeit takes to create policy documents for individul users.

#### Roles
Roles are generally used when you want to give temporary permissions for
specific actions and take it away after work is completed or time has expired.
Roles consist of policy documents that can be given to both users and entities.

#### Trust Relationship
If you have two different accounts and you need to give access to another user
which is another account:

1. Create a policy document for this user
2. Etablish a `Trust Relationship` and give the user the ability to
`Asssume Role`

The user now has this new additional role / permission to perform the required task.

### Extra

* Protect access to your root account at all costs 
* Explicit **Effect: Deny** always superseeds **Effect: Allow**
* Use the **Least Privilge Model**. Give minimum permissions to perform the required task

