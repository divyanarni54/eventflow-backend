from fastapi import APIRouter, Depends
from sqlalchemy.orm import Session

import schemas
import services.event_service as service
from database import SessionLocal

router = APIRouter()

def get_db():
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()

@router.get("/events/all")
def get_events(db: Session = Depends(get_db)):
    return service.get_all_events(db)

@router.post("/events/create")
def create_event(event: schemas.Event, db: Session = Depends(get_db)):
    return service.create_event(db, event)