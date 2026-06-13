package com.eventflow.authservice.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eventflow.authservice.model.User;
import com.eventflow.authservice.service.UserService;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserService service;

    // SIGNUP API
    @PostMapping("/signup")
    public Map<String, Object> signup(
        @RequestBody User user
    ){

        return service.signup(user);
    }

    // LOGIN API
    @PostMapping("/signin")
    public Map<String, Object> signin(
        @RequestBody User user
    ){

        return service.signin(user);
    }
}