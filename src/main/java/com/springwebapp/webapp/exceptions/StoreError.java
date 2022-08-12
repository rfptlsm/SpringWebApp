package com.springwebapp.webapp.exceptions;

import java.util.Date;

import lombok.Data;

@Data
public class StoreError {
    private int status;
    private String message;
    private Date timestamp;

    public StoreError(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = new Date();
    }
}
