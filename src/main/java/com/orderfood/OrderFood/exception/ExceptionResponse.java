package com.orderfood.OrderFood.exception;

public class ExceptionResponse {
    private int statusCode;
    private String message;
    public ExceptionResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}
