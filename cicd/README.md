# Continuous Integration & Continuous Deployment

## Contents

- [GitHub Actions](/githubactions)
- [Kubernetes](/k8s)

## TL:DR

Read till the end for bonus tips. :D

### Source Code

1. Write neat and clean code with some coding guidelines or standards.
2. It is good to keep some reviewers so that nobody blindly pushes something which may break your application.

### Build

1. Compile Source and Dependencies
2. Run Unit Tests
3. Check and Enforce Code Coverage

### Test Environment

1. Run Integration Tests

### Production Environment

1. Make sure your dev changes reflect exactly in production
2. Have alarms on errors, latency & key business metrics automatically
3. Ability to quickly rollback 
4. Bake Period - 24 Hours
5. Canary: Soemthing which tests production with expected input and output like a bot or cronjob

---

## Designing a Modern CI/CD Pipline

### Source Stage

Every CI/CD pipeline begins with something called a source stage which is some hosting platform for your code like GitHub.

Some processes which can be implemented at the source stage are:

- **Branch Protection Rules**: No one should be able to push to any branch
- **Linting**: Code standardaization across the platform

### Build Stage

This stage consists of compiling the source code and / or creating an image of your application with Docker.
After the image has been created, we can run unit tests of our application and catch errors before moving on to the next stage.
Another popular step is a code coverage check which gives us information about what percentage of our code has been tested.
The pipeline can be stopped if the code coverage criteria has not been met.

### Test Stage

We run our integration tests here and other functionalities of our application in this stage.
In case we are testing a service which depends on other services, we can

- Mock the other service if feasible
- Setup a full testing environment with ![docker compose](https://docs.docker.com/compose/) or in a kubernetes cluster

### Release Stage

Here we move our built images to a private registry. The deployment environment can be a:

- QA Testing
- Pre Production / Staging environment 
- Production Environment

### Bonus

- Have a on/off switch to skip specific steps
- Have separate databases for test and production
- Make sure the correct environment, variables and database is loaded for a specific environment

Happy CI/CD-ing.
