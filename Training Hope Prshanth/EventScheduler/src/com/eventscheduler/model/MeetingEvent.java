package com.eventscheduler.model;

import java.time.LocalDateTime;

// OOP CONCEPTS: Inheritance ("extends Event") and "super" keyword usage
public class MeetingEvent extends Event {
    private static final long serialVersionUID = 1L;
    
    private String location;

    public MeetingEvent(String title, LocalDateTime startTime, int durationMinutes, String location) {
        super(title, startTime, durationMinutes); // Pass to parent
        this.location = location;
    }

    public String getLocation() { return location; }

    // OOP Polymorphism: Child providing specific implementation
    @Override
    public void displayEventDetails() {
        System.out.println("🗓️ [MEETING] " + getTitle() + " | Starts: " + getStartTime() + " | Location: " + location);
    }
}
