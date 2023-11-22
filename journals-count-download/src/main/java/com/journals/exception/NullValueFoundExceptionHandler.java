package com.journals.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NullValueFoundExceptionHandler {

    @ExceptionHandler(value = {NullValueFoundException.class})
    public ResponseEntity<Object> handleNullValue(
           NullValueFoundException foundException
    ){
        NullValueFoundExceptionFields nullValues = new NullValueFoundExceptionFields(
                foundException.getMessage(),
                foundException.getCause(),
                HttpStatus.BAD_REQUEST
        );
      return new ResponseEntity<>(nullValues,HttpStatus.BAD_REQUEST);
    }
}
