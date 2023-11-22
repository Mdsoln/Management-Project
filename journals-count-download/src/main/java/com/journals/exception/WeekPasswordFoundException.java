package com.journals.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class WeekPasswordFoundException {
    private final String message;
    private final Throwable cause;
    private final HttpStatus httpStatus;

}
