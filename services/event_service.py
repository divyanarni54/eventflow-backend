from sqlalchemy.orm import Session
import models

def get_all_events(db: Session):
    return db.query(models.Event).all()

def create_event(db: Session, event):
    new_event = models.Event(
        title=event.title,
        category=event.category,
        location=event.location,
        description=event.description,
        start_time=event.start_time,
        end_time=event.end_time
    )

    db.add(new_event)
    db.commit()
    db.refresh(new_event)

    return new_event