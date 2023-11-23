from fastapi import FastAPI

app = FastAPI(description="Minimal API", doc_url="/docs")

@app.get("/healthcheck")
async def healthcheck():
    return {"status": "healthy"}

