from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware

from database import engine
import models

from controllers.event_controller import router

app = FastAPI(
    title="EventFlow API",
    version="1.0.0"
)

# Create tables automatically
models.Base.metadata.create_all(bind=engine)

# CORS
app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

# Routes
app.include_router(router)

# Home API
@app.get("/")
def home():
    return {"message": "Server is working"}