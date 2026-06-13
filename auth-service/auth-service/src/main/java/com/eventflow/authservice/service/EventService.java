package com.eventflow.authservice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventflow.authservice.model.Event;
import com.eventflow.authservice.repository.EventRepository;

@Service
public class EventService {

    @Autowired
    EventRepository repo;

    // CREATE EVENT
    public Map<String, Object> createEvent(
        Event event
    ){

        // CHECK CONFLICT EVENTS
  
          List<Event> conflicts =
              repo.findByStartTimeBeforeAndEndTimeAfter(
                  event.getEndTime(),
                  event.getStartTime()
              );
          


        // IF CONFLICT EXISTS
        if(!conflicts.isEmpty()){

            Map<String, Object> conflictResponse =
                new HashMap<>();

            conflictResponse.put(
                "message",
                "Event timing conflict detected"
            );

            conflictResponse.put(
                "status",
                false
            );

            return conflictResponse;
        }

        // SAVE EVENT
        repo.save(event);

        Map<String, Object> response =
            new HashMap<>();

        response.put(
            "message",
            "Event Created Successfully"
        );

        response.put(
            "status",
            true
        );

        return response;
    }

    // GET EVENTS
    public List<Event> getAllEvents(){

        return repo.findAll();
    }
}