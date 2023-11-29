# FastAPI

Official Documentation: [FastAPI Docs](https://fastapi.tiangolo.com/)
Before running any code, make sure to create a virtual environment with all the dependencies installed.

```bash
python -m venv .venv
. venv/bin/activate
pip install -r requirements.txt
```

To run one of the files in the `servers/` directory:

```bash
hypercorn servers.minimal:app
```

To run the application:

```bash
hypercorn app.asgi:app
```

## Service Structure

    app/
    ├── api.py
    ├── asgi.py
    ├── config.py
    ├── dependencies.py
    ├── enums.py
    ├── exceptions.py
    ├── __init__.py
    ├── models.py
    ├── router.py
    ├── schemas.py
    ├── service.py
    └── utils.py

In case of multiple services, each service can be modularized with its own directory. Shared resources can be defined outside these folders.

    .
    ├── app/
    │   ├── users/
    │   │   ├── api.py
    │   │   ├── config.py
    │   │   ├── dependencies.py
    │   │   ├── enums.py
    │   │   ├── exceptions.py
    │   │   ├── __init__.py
    │   │   ├── models.py
    │   │   ├── router.py
    │   │   ├── schemas.py
    │   │   ├── service.py
    │   │   └── utils.py
    │   ├── orders/
    │   │   ├── api.py
    │   │   ├── config.py
    │   │   ├── dependencies.py
    │   │   ├── enums.py
    │   │   ├── exceptions.py
    │   │   ├── __init__.py
    │   │   ├── models.py
    │   │   ├── router.py
    │   │   ├── schemas.py
    │   │   ├── service.py
    │   │   └── utils.py
    │   ├── asgi.py
    │   ├── config.py
    │   ├── dependencies.py
    │   ├── enums.py
    │   ├── exceptions.py
    │   ├── __init__.py
    │   ├── models.py
    │   └── utils.py
    ├── Dockerfile
    ├── pyproject.toml
    ├── readme.md
    └── requirements.txt

## Router Structure

    app/
    ├── api/
    ├── config/
    ├── models/
    ├── routers/
    ├── schemas/
    ├── services/
    ├── utils/
    ├── asgi.py
    ├── dependencies.py
    ├── enums.py
    ├── exceptions.py
    └── __init__.py


