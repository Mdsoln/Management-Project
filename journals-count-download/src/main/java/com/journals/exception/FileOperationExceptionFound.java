package com.journals.exception;

public class FileOperationExceptionFound extends RuntimeException{

    public FileOperationExceptionFound(String message) {
        super(message);
    }

    public FileOperationExceptionFound(String message, Throwable cause) {
        super(message, cause);
    }
}
