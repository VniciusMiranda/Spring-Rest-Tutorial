package com.Miranda.osworks.osworksapi.api.exceptionhandler;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {

        var errorPresentations = new ArrayList<Problem.Field>();

        for(ObjectError error : ex.getBindingResult().getAllErrors()){

            errorPresentations.add(new Problem.Field(
                    ((FieldError) error).getObjectName(),
                     error.getDefaultMessage()
            ));
        }

        var problem = new  Problem(400, LocalDateTime.now(),
                "One or more fields are invalid." +
                    "Try again with new values.",
                errorPresentations);

        return super.handleExceptionInternal(ex, problem, headers, status, request);
    }
}