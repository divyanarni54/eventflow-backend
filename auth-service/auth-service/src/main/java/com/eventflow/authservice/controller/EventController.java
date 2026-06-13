package com.eventflow.authservice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eventflow.authservice.model.Event;
import com.eventflow.authservice.service.EventService;

@RestController
@RequestMapping("/events")
@CrossOrigin("*")

public class EventController {

    @Autowired
    EventService service;

    // CREATE EVENT
    @PostMapping("/create")
    public Map<String, Object> createEvent(
        @RequestBody Event event
    ){

        return service.createEvent(event);
    }

    // GET ALL EVENTS
    @GetMapping("/all")
    public List<Event> getAllEvents(){

        return service.getAllEvents();
    }
}