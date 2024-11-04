package com.honeywell.intelligrated.wes.annotation.rest;

public class ServiceResponse {
    private String message;

    public ServiceResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}