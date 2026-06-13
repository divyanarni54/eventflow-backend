package com.eventflow.authservice.repository;

import com.eventflow.authservice.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository
        extends JpaRepository<Registration, Long> {

}