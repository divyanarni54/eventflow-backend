package com.eventflow.authservice.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventflow.authservice.model.Event;

@Repository
public interface EventRepository
        extends JpaRepository<Event, Long> {

    List<Event>
    findByStartTimeBeforeAndEndTimeAfter(

            LocalDateTime endTime,
            LocalDateTime startTime
    );
}