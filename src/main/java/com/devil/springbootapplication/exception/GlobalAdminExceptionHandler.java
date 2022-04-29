package com.devil.springbootapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalAdminExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<CustomErrorResponse> handleException(CustomAdminException ex){
        CustomErrorResponse errorResponse = new CustomErrorResponse();
        errorResponse.setStatusCode(HttpStatus.UNAUTHORIZED.value());
        errorResponse.setStatusMessage("UNAUTHORIZED");
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler
    public ResponseEntity<CustomErrorResponse> handleException(Exception ex){
        CustomErrorResponse errorResponse = new CustomErrorResponse();
        errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setStatusMessage("UNAUTHORIZED");
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}