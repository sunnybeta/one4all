FROM python:3.10
WORKDIR /app
COPY . .
RUN python -m venv .venv
RUN .venv/bin/pip install --upgrade pip
RUN .venv/bin/pip install -r requirements.txt
EXPOSE 8000
# ENV PYTHONPATH="$PATH:/app"
CMD [".venv/bin/hypercorn","app.asgi:app", "--bind", "0.0.0.0:8000"]
