package com.macys.common.pricing.services.api.exception;

import org.springframework.http.HttpStatus;

import lombok.Generated;

import java.util.Date;
@Generated
public class ApiError {
    private final Integer statusCode;
    private final String status;
    private final String message;
    private Date date;

    public ApiError(HttpStatus status, String message, Date date) {
        this.statusCode = status.value();
        this.status = status.toString();
        this.message = message;
        this.date=date;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }
}
