package com.eventflow.authservice.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventflow.authservice.model.User;
import com.eventflow.authservice.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository repo;

    // SIGNUP
    public Map<String, Object> signup(User user){

        Map<String, Object> response = new HashMap<>();

        try {

            // CHECK EMAIL EXISTS
            if(repo.existsByEmail(user.getEmail())){

                response.put("message", "Email already exists");
                response.put("status", false);

                return response;
            }

            // SAVE USER
            User savedUser = repo.save(user);

            response.put("message", "Registration Success");
            response.put("status", true);
            response.put("user", savedUser);

        } catch (Exception e) {

            response.put("message", e.getMessage());
            response.put("status", false);
        }

        return response;
    }

    // LOGIN
    public Map<String, Object> signin(User user){

        Map<String, Object> response = new HashMap<>();

        try {

            User existing = repo.findByEmail(user.getEmail());

            if(existing == null){

                response.put("message", "User Not Found");
                response.put("status", false);

                return response;
            }

            if(existing.getPassword().equals(user.getPassword())){

                response.put("message", "Login Success");
                response.put("status", true);
                response.put("user", existing);

            } else {

                response.put("message", "Invalid Password");
                response.put("status", false);
            }

        } catch (Exception e) {

            response.put("message", e.getMessage());
            response.put("status", false);
        }

        return response;
    }
}