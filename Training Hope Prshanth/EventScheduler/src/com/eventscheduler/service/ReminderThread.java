package com.eventscheduler.service;

import com.eventscheduler.model.Event;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * MULTITHREADING CONCEPTS:
 * By implementing 'Runnable', this class can run entirely in the background 
 * at the EXACT same time the user is typing in the console menu!
 */
public class ReminderThread implements Runnable {
    
    private final EventManager eventManager;

    public ReminderThread(EventManager eventManager) {
        this.eventManager = eventManager;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Tells the thread to sleep for 10 seconds to save CPU power
                Thread.sleep(10000); 
                
                LocalDateTime now = LocalDateTime.now();
                // We use our Java 8 Stream method to instantly get future events
                List<Event> upcoming = eventManager.getUpcomingEvents();
                
                for (Event event : upcoming) {
                    // How many minutes until the event?
                    long minutesUntil = ChronoUnit.MINUTES.between(now, event.getStartTime());
                    
                    if (minutesUntil == 1) {
                        System.out.println();
                        System.out.println("⏰ *** BEEP BEEP *** ⏰");
                        System.out.println("Reminder: Event '" + event.getTitle() + "' is starting in 1 minute!");
                        
                        // We reprint the menu prompt so the console doesn't look broken to the user
                        System.out.print("Enter your choice: "); 
                    }
                }
            } catch (InterruptedException e) {
                // Error handling in threads
                System.out.println("Reminder thread interrupted.");
                break;
            }
        }
    }
}
