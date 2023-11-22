package com.journals.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ArticleExceptionHandler {
    @ExceptionHandler(value = {ArticleNotFoundException.class})
    public ResponseEntity<Object> handleArticleNotFoundException(
            ArticleNotFoundException articleNotFoundException
    ){
         ArticleException articleException = new ArticleException(
                 articleNotFoundException.getMessage(),
                 articleNotFoundException.getCause(),
                 HttpStatus.NOT_FOUND
         );
         return new ResponseEntity<>(articleException,HttpStatus.NOT_FOUND);
    }
}
