package com.journals.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FileOperationExceptionHandler {

    @ExceptionHandler(value = {FileOperationExceptionFound.class})
    public ResponseEntity<Object> fileOperationException(
            @org.jetbrains.annotations.NotNull FileOperationExceptionFound fileOperationExceptionFound
    ){
        FileOperationException fileOperationException = new FileOperationException(
                fileOperationExceptionFound.getMessage(),
                fileOperationExceptionFound.getCause(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
        return new ResponseEntity<>(fileOperationException,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
