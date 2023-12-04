# Github Actions

*Source*

![DevOps Journey](https://www.youtube.com/@DevOpsJourney)

*GitHub Actions* facilitates continuous integration and deployment within GitHub.
We define a workflow configuration file and the rest is taken care of.

## Key Sections

A GitHub configuration consists of the following components:

- workflow name
- events
- jobs
- runner
- steps
- actions

## Example

We want to lint our code base. :O

Let's create a workflow file.

### Workflow name

```yaml
name: super-linter
```

### Event

The code must run whenever a developer pushes some code.

```yaml
name: super-linter
on: push
```

### Jobs

Specify the name of the jobs

```yaml
name: super-linter
on: push
jobs:
    please-lint:
        name: Lint Code Base
```

### Runner

Specify the environment / OS where the job(s) must be executed.

```yaml
name: super-linter
on: push
jobs:
    please-lint:
        name: Lint Code Base
jobs:
    please-lint:
        name: Lint Code Base
        runs-on: ubuntu-latest
```

### Steps

Mention the particular steps to be executed in the correct order.

```yaml
name: super-linter
on: push
jobs:
    please-lint:
        name: Lint Code Base
jobs:
    please-lint:
        name: Lint Code Base
        runs-on: ubuntu-latest
        steps:
            - name: Checkout Code
              uses: actions/checkout@v3
            
            - name: Run Super Linter
              uses: github/super-linter@v3
              env:
                DEFAULT_BRANCH: main
                GITHUB_TOKEN: ${{secrets.GITHUB_TOKEN}}
```


