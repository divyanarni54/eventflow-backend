package com.eventflow.authservice.controller;

import com.eventflow.authservice.model.Registration;
import com.eventflow.authservice.repository.RegistrationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registrations")

@CrossOrigin("*")

public class RegistrationController {

    @Autowired
    private RegistrationRepository registrationRepository;

    @PostMapping("/register")
    public Registration registerEvent(
            @RequestBody Registration registration) {

        return registrationRepository.save(registration);
    }

    @GetMapping("/all")
    public Object getAllRegistrations() {

        return registrationRepository.findAll();
    }
}