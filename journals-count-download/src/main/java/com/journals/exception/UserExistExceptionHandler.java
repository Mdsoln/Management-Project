package com.journals.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExistExceptionHandler {

    @ExceptionHandler(value = {UserFoundException.class})
    public ResponseEntity<Object> emailExistsHandler(
            UserFoundException userFoundException
    ){
        UserException userException = new UserException(
                userFoundException.getMessage(),
                userFoundException.getCause(),
                HttpStatus.CONFLICT
        );
        return new ResponseEntity<>(userException,HttpStatus.CONFLICT);
    }
}
