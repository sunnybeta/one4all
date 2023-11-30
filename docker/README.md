# Docker

| ![Docker]("public/docker.jpg") |
|:--:|
| Credits: *[Laurel (@bloglaurel)](https://www.deviantart.com/bloglaurel/gallery)* |

## Open Container Initiative 

OCI standardizes container runtime, image and distribution specifications. This ensure that the container ecosystem remains open and not tied to a single vendor.

## What is Docker?

Docker is a standardized unit of software used to deploy applications.
Containers package up all the code and dependencies for an app so it can be used on any server.
It only virtualizes the application layer and uses the kernel of the host.
Containers work in isolation and can perform tasks independent of other containers.
Docker provides consistency, automation, scaling and stability with packaging and deployment support.

## Container?

### What is a container?

Container is a way to package an application with all the necessary dependencies and configurations.
This package is easily shared and moved around which makes the development and deployment easier.
Containers are layers of a linux base image and an application image with configuration.

### Where can I find container images?

Companies have private repositories for mangaing their container images.
They are aslo publically available for Docker container images at [Docker Hub](hub.docker.com).

### Life Before Containers

- Each developer needs to install the application speicifc version
- Installation process is different on each OS environments
- Individual steps can go wrong and might require some debugging
- Textual guide for deployment
- Configuration on the servers are needed
- External dependencies on ther server OS
- Dependency version problems

### Life After Containers

- Images are packaged with all needed configuration
- One command to install the application
- Run the same application with 2 different versions
- Developer and Operations work together to package the aplication in a container
- Avoid configuring anything on the server

## Key Components

Docker has three key components:

### Docker Client

This is the primary interface for interacting with docker.
It communicates with the docker daemon for managing varuoys docker objects including images and containers.

### Docker Daemon

This is the core engine which manages container operations.
It resides on a system running the docker software commonly known as the docker host and can utilise OCI compliant runtimes like containerd for running containers.

### Docker Registeries

These contain and store container images.
The most popular is registry [Docker Hub](hub.docker.com).

### Life Before Containers

- Each developer needs to install the dependencies' speicifc version
- Installation process might be different on each OS environments
- Individual steps can go wrong and might require some debugging
- Reference to a textual guide for deployment
- Configuration on the servers are needed
- External dependencies was probably on ther server OS
- Dependency version problems

### Life After Containers

- Images are now packaged with all the needed configuration
- Reduces to one command to install the application
- We can tun the same application with 2 different versions
- Developer and Operations can work together to package the application in a container
- Successfullyr avoid configuring anything on the server

## Key Components

Docker has three key components:

### Docker Client

This is the primary interface for interacting with docker.
It communicates with the docker daemon for managing varuoys docker objects including images and containers.

### Docker Daemon

This is the core engine which manages container operations.
It resides on a system running the docker software commonly known as the docker host and can utilise OCI compliant runtimes like containerd for running containers.

### Docker Registeries

These contain and store container images.
The most popular is registry [Docker Hub](http.

## Some Important Commands

### Pull

Retrieve an image from docker hub

```bash
docker pull alpine
```

### Images and Containers

```bash
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
Docker build ignores all files mentioend in the special `.dockerignore` file in the same directory.

```bash
docker build -t IMAGE_NAME:IMAGE_VERSION .
```

### Run

*Run the docker image attached to `localhost:localport`.*

This starts a container from an image managed by the daemon.
Here containerd can serve as underlying runtimes.

- The `-e` flag allows you to set environment variables for the image (default username, password for a database image)
- The `-d` flag runs it in a detached mode (Runs in the background)
- The `-p` flag exposes a certain port (docker image port) of the image and attaches it to the hosts local port.

```bash
docker run -d -p localport:dockerport --name CONTAINER_NAME -e ENVIRONMENT_VARIABLE=niceValue IMAGE_NAME  
```

### Interactive

Interact with the the contents of the docker image for debugging purposes.

```bash
docker exec -it <CONTAINER_HASH> bash
```

## Volumes

* A directory on the host is mounted on the container directory

### Host Volume

User decide which folder on the host should be mounted

```bash
docker run -d -p localport:dockerport -v /home/mouny/data:/var/lib/mysql/data --name CONTAINER_NAME IMAGE_NAME 
```

### Anonymous Volume

Docker decides where on the host that the directory should be mounted

```bash
docker run -d -p localport:dockerport -v /var/lib/mysql/data --name CONTAINER_NAME IMAGE_NAME 
```

### Named Volume

Named volume provides a name to the volume mounted so that it can be referenced by another container in case of shared data and is the volume which should be used in production.

```bash
docker run -d -p localport:dockerport -v name:/var/lib/mysql/data --name CONTAINER_NAME IMAGE_NAME 
```


## Compose

We can map the entire docker run command for different docker iamges into one file and execute the simultaneously.
If the filename is `docker-compose.yml`, we can skip the `-f` flag and docker will recognize the file correctly.

```yaml
services:
  mongodb:
    image: 'mongo'
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
      - ME_CONFIG_MONGODB_SERVER=mongodb
```

To start the docker containers:

```bash
docker compose -f compose.yml up
```

## Dockerfiles

These are just templates.
Do update the Dockerfiles to suit your needs like adding environment variables and installing third party dependencies or using another image altogether.

### FastAPI

```dockerfile
FROM python:3.10-slim
WORKDIR /app
RUN python -m venv .venv
RUN .venv/bin/pip install -r requirements.txt
COPY . .
EXPOSE 8000
CMD [".venv/bin/uvicorn", "app.asgi:app", "--host", "0.0.0.0"]
```

### Spring

```dockerfile
FROM eclipse-temurin:17-alpine
WORKDIR /app
COPY ./target/*.jar app.jar
CMD ["java", "-jar", "app.jar"]
```

### Go

```dockerfile
FROM golang:1.19
WORKDIR /app
COPY go.mod go.sum ./
RUN go mod download
COPY *.go ./
RUN CGO_ENABLED=0 GOOS=linux go build -o /goapp
EXPOSE 8080
CMD ["/goapp"]
```

### Express

```dockerfile
FROM node:lts-alpine
WORKDIR /app
COPY package*.json .
RUN npm run build
EXPOSE 8000
CMD ["node", "/dist/app.js"]
```

FIN
