package com.Miranda.osworks.osworksapi.api.exceptionhandler;


import com.Miranda.osworks.osworksapi.domain.exception.DomainException;
import com.Miranda.osworks.osworksapi.domain.exception.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
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
                    ((FieldError) error).getField(),
                     error.getDefaultMessage()
            ));
        }

        var problem = new  Problem(status.value(), OffsetDateTime.now(),
                "One or more fields are invalid." +
                    "Try again with new values.");
        problem.setFields(errorPresentations);

        return super.handleExceptionInternal(ex, problem, headers, status, request);
    }

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<Object> domainHandle(DomainException ex, WebRequest request){

        var status = HttpStatus.BAD_REQUEST;

        var problem = new Problem(status.value(),OffsetDateTime.now(), ex.getMessage());

        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> entityNotFoundHandle(DomainException ex, WebRequest request){

        var status = HttpStatus.NOT_FOUND;

        var problem = new Problem(status.value(),OffsetDateTime.now(), ex.getMessage());

        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }


}
