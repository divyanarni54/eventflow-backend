from pydantic import BaseModel

class Event(BaseModel):

    title: str
    category: str
    location: str
    description: str
    start_time: str
    end_time: str

    class Config:
        orm_mode = True