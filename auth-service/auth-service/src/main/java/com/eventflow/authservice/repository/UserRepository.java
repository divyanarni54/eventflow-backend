package com.eventflow.authservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventflow.authservice.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    boolean existsByEmail(String email);
}