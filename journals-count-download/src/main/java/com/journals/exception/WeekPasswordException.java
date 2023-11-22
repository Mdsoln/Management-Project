package com.journals.exception;

public class WeekPasswordException extends RuntimeException{
    public WeekPasswordException(String message) {
        super(message);
    }

    public WeekPasswordException(String message, Throwable cause) {
        super(message, cause);
    }
}
