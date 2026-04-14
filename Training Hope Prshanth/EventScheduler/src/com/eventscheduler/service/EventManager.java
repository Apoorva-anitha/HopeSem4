package com.eventscheduler.service;

import com.eventscheduler.exception.TimeConflictException;
import com.eventscheduler.model.Event;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * CORE LOGIC: COLLECTIONS & STREAMS API
 */
public class EventManager {
    
    // 1. HashMap: Gives us incredibly fast O(1) lookups if we know the Event ID.
    private final Map<String, Event> eventMap;
    
    // 2. TreeSet: Automatically sorts all elements. Since our Event class implements Comparable, 
    // the TreeSet uses getStartTime() to keep the entire calendar perfectly chronological!
    private final TreeSet<Event> sortedEvents;

    public EventManager() {
        this.eventMap = new HashMap<>();
        this.sortedEvents = new TreeSet<>();
    }

    public void addEvent(Event newEvent) throws TimeConflictException {
        // Exception Handling & Logic: Prevent double booking
        for (Event existingEvent : sortedEvents) {
            if (isOverlapping(existingEvent, newEvent)) {
                throw new TimeConflictException("Time conflict! Cannot add '" + newEvent.getTitle() + 
                                                "' because it overlaps with '" + existingEvent.getTitle() + "'");
            }
        }

        // Add to both Data Structures
        eventMap.put(newEvent.getId(), newEvent);
        sortedEvents.add(newEvent);
    }

    public Event getEventById(String id) {
        return eventMap.get(id); // Instant lookup! No loops required.
    }

    public void removeEvent(String id) {
        Event e = eventMap.remove(id);
        if (e != null) {
            sortedEvents.remove(e);
        }
    }

    public void displayAllEvents() {
        System.out.println("=== ALL SCHEDULED EVENTS ===");
        if (sortedEvents.isEmpty()) {
            System.out.println("  No events scheduled.");
            return;
        }
        // Because it's a TreeSet, this loop naturally prints them in order!
        for (Event e : sortedEvents) {
            e.displayEventDetails();
        }
        System.out.println("============================");
    }

    // --- JAVA 8 STREAMS API ---

    public List<Event> getUpcomingEvents() {
        LocalDateTime now = LocalDateTime.now();
        // An elegant functional approach to filter lists without messy if-statements
        return sortedEvents.stream()
                .filter(e -> e.getStartTime().isAfter(now))
                .collect(Collectors.toList());
    }

    // Helper Method needed for Phase 4 (Persistence)
    public List<Event> getAllEvents() {
        return new ArrayList<>(sortedEvents);
    }

    // Used to load data from the file back into our system during startup
    public void addAllEventsFromFile(List<Event> loadedEvents) {
        for (Event e : loadedEvents) {
            eventMap.put(e.getId(), e);
            sortedEvents.add(e);
        }
    }

    // A standard algorithm to check if Event 1 and Event 2 overlap in time
    private boolean isOverlapping(Event e1, Event e2) {
        return e1.getStartTime().isBefore(e2.getEndTime()) && 
               e1.getEndTime().isAfter(e2.getStartTime());
    }
}
