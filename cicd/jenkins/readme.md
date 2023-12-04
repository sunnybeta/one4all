# Jenkins

Jenkins is an automation platform for building, testing and deploying software using pipelines. 

## Infrastructure

Jenkins' infrastructure consists of two components:

- **Master Server**: Server which controls the pipelines and schedules source code builds
- **Agents**: Services which perform the tasks / builds

There are two types of agents:

**Pernament Agents**: Dedicated servers for running jenkins jobs. These neeed to have Java installed and SSH setup along with additional build tools
**Cloud Agents**: Dynamic agents spun up on demand

## Build Types

### Freestyle Builds

These builds are the simplest builds to create. They consist of shell commands

### Piplines

Pipelines are written in the groovy language and consists of the standard CI/CD design.

