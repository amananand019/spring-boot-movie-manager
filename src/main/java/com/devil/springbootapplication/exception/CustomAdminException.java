package com.devil.springbootapplication.exception;

public class CustomAdminException extends RuntimeException{
    public CustomAdminException(String message) {
        super(message);
    }

    public CustomAdminException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomAdminException(Throwable cause) {
        super(cause);
    }
}