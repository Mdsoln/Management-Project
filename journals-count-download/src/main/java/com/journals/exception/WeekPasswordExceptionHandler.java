package com.journals.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class WeekPasswordExceptionHandler {

    @ExceptionHandler(value = {WeekPasswordException.class})
    public ResponseEntity<Object> weekPasswordHandler(
           WeekPasswordException weekPasswordException
    ){
        WeekPasswordFoundException weekPassword = new WeekPasswordFoundException(
                weekPasswordException.getMessage(),
                weekPasswordException.getCause(),
                HttpStatus.BAD_REQUEST
        );
        return new ResponseEntity<>(weekPassword,HttpStatus.BAD_REQUEST);
    }
}
