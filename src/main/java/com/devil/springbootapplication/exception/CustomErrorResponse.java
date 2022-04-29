package com.devil.springbootapplication.exception;

public class CustomErrorResponse {
    private int statusCode;
    private String statusMessage;
    private String message;
    private long timestamp;

    public CustomErrorResponse() {
    }

    public CustomErrorResponse(int statusCode, String statusMessage, String message, long timestamp) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.message = message;
        this.timestamp = timestamp;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}