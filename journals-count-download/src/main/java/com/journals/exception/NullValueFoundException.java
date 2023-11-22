package com.journals.exception;

public class NullValueFoundException extends RuntimeException{
    public NullValueFoundException(String message) {
        super(message);
    }
    public NullValueFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
