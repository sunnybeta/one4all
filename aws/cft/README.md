# Cloud Formation Template

Source: [Be A Better Dev](https://www.youtube.com/watch?v=0Sh9OySCyb4)

A *Cloud Formation Template* is an IaC provider where the user can declarae the AWS resources that make up a stack.

- We can write a YAML file and upload it to AWS which will create the stack for us without manual work.
- If something goes wrong, then we can easily rollback.
- Great for regional expansion
- Allows code review mechanism for infrastructural change
- Can be integrated with CI pipeline

**Stack.** A stack is a logical grouping of your template and their resources.

- Combine multiple template files and deploy all at once with same stack
- Nested Stack for graph like relationship

**Changesets.** It is a diff between two CFTs.

- Shows a preview of what cloud formation template will do next in incremental steps

## Example: Dynamo DB


```yaml
AWSTemplateFormatVersion: 2010-09-09
Resources:
    TweetTable:
        Type: AWS::DynamoDB:Table
        Properties:
            TableName: TweetTable_dev
            AttributeDefinitions:
                - AttributeName: "UserID"
                  AttributeType: "S"
                - AttributeName: "Tweet"
                  AttributeType: "S"
            KeySchema:
                - AttributeName: "UserID"
                  KeyType: "HASH"
                - AttributeName: "Tweet"
                  KeyType: "RANGE"
            TimeToLiveSpecification:
                AttributeName: "ExpirationTime"
                Enabled: true
            ProvisionThroughput:
                ReadCapacityUnits: "3"
                WriteCapacityUnits: "3"
        DependsOns:
            - DynamoDBQueryPolicy
    DynamoDBQueryPolicy:
        Type: "AWS::IAM::Policy"
        Properties:
            PolicyName: DynamoDBQueryPolicy
            PolicyDocument: 
                Version"2023-10-20"
                Statement:
                    - Effect: "Allow"
                      Action: "dynamodb:Query"
                      Resource: "*"
            Roles:
                - Ref: "TweetTableQueryRole"

    TweetTableQueryRole:
        Type: "AWS::IAM::Role"
        Properties:
            AssumeRolePolicyDocument:
                Version: "2023-10-20"
                Statement:
                    - Effect: "Allow"
                      Principal:
                        Service:
                            - "dynamodb.amazonaws.com"
                      Action:
                        - "sts:AssumeRole"
            Path: "/"

```

