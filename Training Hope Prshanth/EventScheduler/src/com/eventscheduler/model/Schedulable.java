package com.eventscheduler.model;

import java.time.LocalDateTime;

// OOP: Interface to enforce structure
public interface Schedulable {
    String getTitle();
    LocalDateTime getStartTime();
    LocalDateTime getEndTime();
    void displayEventDetails();
}
