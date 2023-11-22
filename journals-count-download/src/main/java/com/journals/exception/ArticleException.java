package com.journals.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Data
public class ArticleException {
    private final String message;
    private final Throwable cause;
    private final HttpStatus httpStatus;

}
