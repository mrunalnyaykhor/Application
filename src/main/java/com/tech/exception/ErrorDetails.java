package com.tech.exception;

import java.util.Date;
import java.util.List;

public class ErrorDetails {
    private Date timestamp;
    private List<String> message;
    private String details;

    public ErrorDetails(Date timestamp, List<String> message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public List<String> getMessage() {
        return message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getDetails() {
        return details;
    }
}
