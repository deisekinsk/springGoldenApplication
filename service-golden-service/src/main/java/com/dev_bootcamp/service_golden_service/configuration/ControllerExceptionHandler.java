package com.dev_bootcamp.service_golden_service.configuration;

import com.dev_bootcamp.service_golden_service.exception.KeyPassDuplicatedException;
import com.dev_bootcamp.service_golden_service.exception.KeyPassNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;

@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(KeyPassDuplicatedException.class)
    private ProblemDetail handlerKeyPassDuplicated (KeyPassDuplicatedException keyPassDuplicatedException){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT,
                keyPassDuplicatedException.getMessage());
                problemDetail.setTitle("CONFLICT Duplicated Key Pass");
                problemDetail.setType(URI.create("http://localhost/9002/document/keypass-duplicated"));
                return problemDetail;
    }

    @ExceptionHandler(KeyPassNotFoundException.class)
    private ProblemDetail handlerKeyPassNotFound(KeyPassNotFoundException keyPassNotFoundException){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,
                keyPassNotFoundException.getMessage());
                problemDetail.setTitle("NOT FOUND Key Pass");
                problemDetail.setType(URI.create("http://localhost/9002/document/keypass-not-found"));
                return problemDetail;
    }
}
