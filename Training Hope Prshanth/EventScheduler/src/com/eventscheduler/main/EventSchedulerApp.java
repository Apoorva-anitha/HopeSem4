package com.eventscheduler.main;

import com.eventscheduler.exception.TimeConflictException;
import com.eventscheduler.model.MeetingEvent;
import com.eventscheduler.service.EventManager;
import com.eventscheduler.service.ReminderThread;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * MAIN CONSOLE APPLICATION (UI)
 */
public class EventSchedulerApp {
    public static void main(String[] args) {
        EventManager eventManager = new EventManager();
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        // MULTITHREADING: Start the Background Daemon
        // 'Daemon' threads are tied to the main app loop. When you exit option 4, the thread auto-dies!
        Thread reminderThread = new Thread(new ReminderThread(eventManager));
        reminderThread.setDaemon(true);
        reminderThread.start();

        System.out.println("======================================");
        System.out.println("    WELCOME TO EVENT SCHEDULER PRO    ");
        System.out.println("======================================");

        while (true) {
            System.out.println("\n1. Add a Meeting");
            System.out.println("2. View All Events (Sorted)");
            System.out.println("3. View Upcoming Events Only");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {
                // We use Integer.parseInt so it strictly demands a number
                int choice = Integer.parseInt(scanner.nextLine());

                if (choice == 1) {
                    System.out.print("Enter Meeting Title: ");
                    String title = scanner.nextLine();
                    
                    System.out.print("Enter Start Time (yyyy-MM-dd HH:mm): ");
                    String timeStr = scanner.nextLine();
                    LocalDateTime startTime = LocalDateTime.parse(timeStr, formatter);
                    
                    System.out.print("Enter Duration (Minutes): ");
                    int duration = Integer.parseInt(scanner.nextLine());
                    
                    System.out.print("Enter Location: ");
                    String location = scanner.nextLine();

                    // OOP: Creating the specific Child Class
                    MeetingEvent meeting = new MeetingEvent(title, startTime, duration, location);
                    
                    // EXCEPTION HANDLING: Will strictly throw TimeConflictException if overlapping!
                    eventManager.addEvent(meeting);
                    System.out.println("✅ Meeting scheduled successfully!");

                } else if (choice == 2) {
                    eventManager.displayAllEvents();
                } else if (choice == 3) {
                    System.out.println("=== UPCOMING EVENTS ===");
                    // JAVA 8: Using forEach with a Lambda expression!
                    eventManager.getUpcomingEvents().forEach(e -> e.displayEventDetails());
                } else if (choice == 4) {
                    System.out.println("Exiting Application. Goodbye!");
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter 1-4.");
                }
                
            // Our completely Custom Exception catching the overlap!
            } catch (TimeConflictException e) {
                System.out.println("❌ CONFLICT ERROR: " + e.getMessage());
            // Catch-all prevents the entire system from crashing if someone types "hello" instead of a number
            } catch (Exception e) {
                System.out.println("❌ FORMAT ERROR: Invalid input type or date format. Please try again.");
            }
        }
        
        scanner.close();
    }
}
