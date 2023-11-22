package com.journals.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class FileOperationException {
    private final String message;
    private final Throwable cause;
    private final HttpStatus httpStatus;
}
