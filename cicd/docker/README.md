# Docker

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
