package com.example.travel.exception;


import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler
{
   
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleUserAlreadyExistsException(UserAlreadyExistsException exception,
                                                                                 WebRequest webRequest){
    	ErrorResponse errorResponse = new ErrorResponse(
        		LocalDateTime.now(),
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                webRequest.getDescription(true)
               
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorResponse> handleAccessDeniedException(AccessDeniedException exception,
                                                                                 WebRequest webRequest){
    	ErrorResponse errorResponse = new ErrorResponse(
        		LocalDateTime.now(),
                HttpStatus.UNAUTHORIZED,
                exception.getMessage(),
                webRequest.getDescription(true)
               
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception exception,
                                                                            WebRequest webRequest) {
    	ErrorResponse errorResponse = new ErrorResponse(
        		LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getMessage(),
                webRequest.getDescription(true)
               
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
