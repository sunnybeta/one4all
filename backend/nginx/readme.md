# NGINX

## Installation

```bash
docker pull nginx
docker run -d -p 8080:80 --name- reverse-proxy nginx
```

Visit `localhost:8080/` for a greeting.


