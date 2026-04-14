package com.eventscheduler.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * OOP CONCEPTS DEMONSTRATED:
 * 1. Abstract Class: Cannot be instantiated directly.
 * 2. Interfaces: Schedulable (Behavior), Serializable (File I/O), Comparable (Collections/TreeSet).
 * 3. Encapsulation: private fields with public getters.
 */
public abstract class Event implements Schedulable, Serializable, Comparable<Event> {
    private static final long serialVersionUID = 1L;
    
    private final String id;
    private String title;
    private LocalDateTime startTime;
    private int durationMinutes;

    public Event(String title, LocalDateTime startTime, int durationMinutes) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.startTime = startTime;
        this.durationMinutes = durationMinutes;
    }

    public String getId() { return id; }
    
    @Override
    public String getTitle() { return title; }

    @Override
    public LocalDateTime getStartTime() { return startTime; }

    @Override
    public LocalDateTime getEndTime() { return startTime.plusMinutes(durationMinutes); }

    public int getDurationMinutes() { return durationMinutes; }

    // Abstract method: Polymorphism
    @Override
    public abstract void displayEventDetails();

    // Required by Comparable Interface. Allows TreeSet to automatically sort events by date!
    @Override
    public int compareTo(Event o) {
        return this.startTime.compareTo(o.startTime);
    }

    // Overriding equals and hashCode to allow HashMap O(1) lookups by ID!
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id.equals(event.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
