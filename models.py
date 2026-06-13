from sqlalchemy import Column, Integer, String
from database import Base

class Event(Base):
    __tablename__ = "events"

    id = Column(Integer, primary_key=True, index=True)
    title = Column(String)
    category = Column(String)
    location = Column(String)
    description = Column(String)
    start_time = Column(String)
    end_time = Column(String)