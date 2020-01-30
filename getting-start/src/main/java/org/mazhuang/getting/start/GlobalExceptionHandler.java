package org.mazhuang.getting.start;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * author: mazhuang
 * date: 2020/1/30
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public void exceptionHandler(Exception e) {
        System.out.println("GlobalExceptionHandler: " + e.getMessage());
    }
}
