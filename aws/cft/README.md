# Cloud Formation Template

A *Cloud Formation Template* is an IaC provider where the user can declarat the AWS resources that make up a stack.

- We can write a YAML file and upload it to AWS which will create the stack for us without manual work.
- If something goes wrong, then we can easily rollback.
- Great for regional expansion
- Allows code review mechanism for infrastructural change
- Can be integrated with CI pipeline


```yaml
AppendItemToListFunction:
    Type: ...
        Properties:
            Handler: ...
            Role: ...
            Code:
                Zipfile: ...
            Runtime: ...
```

**Stack.** A stack is a logical grouping of your template and their resources.

- Combine multiple template files and deploy all at once with same stack
- Nested Stack for graph like relationship

**Changesets.** It is a diff between two CFTs.

- Shows a preview of what cloud formation template will do next in incremental steps

