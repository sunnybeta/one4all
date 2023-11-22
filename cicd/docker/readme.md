# Docker

## Open Container Initiative 

OCI standardizes container runtime, image and distribution specifications. This ensure that the container ecosystem remains open and not tied to a single vendor.

## What is Docker ?

- Docker is a standardized unit of software used to deploy applications. Containers package up all the code and dependencies for an app so it can be used on any server.
- Docker only virtualizes the application layer and uses the kernel of the host.
- Containers work in isolation and can perform tasks independent of other containers.
- Docker provides consistency, automation, scaling and stability with packaging and deployment support.


## Container

### What

- A way to package applications with all the necessary dependencies and configurations
- This package is easily shared and moved around which makes the development and deployment easier
- Containers are layers of a linux base image, application image with configuration.

### Where

- Companies have private repositories for mangaing their container images
- They are aslo publically available for Docker container images at ![Docker Hub](hub.docker.com).

### Before Containers

- Each developer needs to install the application speicifc version
- Installation process is different on each OS environments
- Individual steps can go wrong and might require some debugging
- Textual guide for deployment
- Configuration on the servers are needed
- External dependencies on ther server OS
- Dependency version problems

### After Containers

- Images are packaged with all needed configuration
- One command to install the application
- Run the same application with 2 different versions
- Developer and Operations work together to package the aplication in a container
- Avoid configuring anything on the server

## Components

Docker has three key components:

### Docker Client

This is the primary interface for interacting with docker. It communicates with the docker daemon for managing varuoys docker objects including images and containers.

### Docker Daemon

This is the core engine which manages container operations. It resides on a system running the docker software commonly known as the docker host. It can utilise OCI compliant runtimes like containerd for running containers.

### Docker Registeries

These contain and store container images. The most popular is Docker Hub.

## Favourite Commands

### Pull

Retrieve an image from docker hub

```console
docker pull alpine
```

### Images and Containers

```console
docker images
docker image rm IMAGE_HASH

docker container ls
docker container start CONTAINER_HASH
docker container stop CONTAINER_HASH
docker container rm CONTAINER_HASH
```

### Build

*Build an image with the docker file `Dockerfile` in the same directory.*

Create an image which adheres to the OCI standard making it compatible across different runtimes.

```console
docker build -t IMAGE_NAME:IMAGE_VERSION .
```

### Run

*Run the docker image attached to `localhost:localport`.*

This starts a container from an image managed by the daemon.
Here containerd can serve as underlying runtimes.

```console
docker run -d -p localport:dockerport --name CONTAINER_NAME IMAGE_NAME 
```

### Interactive

Interact with the the contents of the docker image for debugging purposes.

```console
docker exec -it CONTAINER_HASH bash
```

## Volumes

* A directory on the host is mounted on the container directory

### Host Volume

User decide which folder on the host should be mounted

```console
docker run -d -p localport:dockerport -v /home/mouny/data:/var/lib/mysql/data --name CONTAINER_NAME IMAGE_NAME 
```

### Anonymous Volume

Docker decides where on the host that the directory should be mounted

```console
docker run -d -p localport:dockerport -v /var/lib/mysql/data --name CONTAINER_NAME IMAGE_NAME 
```

### Named Volume

Named volume provides a name to the volume mounted so that it can be referenced by another container in case of shared data and is the volume which should be used in production.

```console
docker run -d -p localport:dockerport -v name:/var/lib/mysql/data --name CONTAINER_NAME IMAGE_NAME 
```


## Compose

We can map the entire docker run command for different docker iamges into one file and execute the simultaneously.

```yaml
version: '1'
services:
  mongodb:
    image: mongo
      ports:
        - 27017: 27017
      environment:
        - MONGO_INITDB_ROOT=admin
        - MONGO_INITDB_PASSWORD=password
  mongo-express:
    image: mongo-express
      ports:
        - 8080:8080
      enrvrionment:
        - ME_CONFIG_MONGODB_ADMINUSERNAME=admin
        - ME_CONFIG_MONGODB_ADMINPASSWORD=password
        - ME)CONFIG_MONGODB_SERVER=mongodb
```

To start the docker containers:

```console
docker-compose -f compose.yaml up
```


