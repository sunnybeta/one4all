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

