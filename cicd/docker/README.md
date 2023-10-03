# Docker

Docker is a standardized unit of software used to deploy applications. Containers package up all the code and dependencies for an app so it can be used on any server.
Containers work in isolation and can perform tasks independent of other containers.
Docker provides consistency, automation, scaling and stability with packaging and deployment support.

## Favourite Commands

### Build

Build an image with the docker file `Dockerfile` in the same directory.

```console
docker build -t image:version .
```

### Run

Run the docker image attached to `localhost:localport`.

```console
docker run -p localport:dockerport image
```

### Interactive

Interact with the the contents of the docker image for debugging purposes.

```console
docker run -it image bash
```
