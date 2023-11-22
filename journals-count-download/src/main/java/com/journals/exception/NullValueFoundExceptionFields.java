package com.journals.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class NullValueFoundExceptionFields {

    private final String message;
    private final Throwable cause;
    private final HttpStatus status;

}
