package com.eventscheduler.exception;

// Exception Handling: Creating a Custom Checked Exception
public class TimeConflictException extends Exception {
    public TimeConflictException(String message) {
        super(message);
    }
}
