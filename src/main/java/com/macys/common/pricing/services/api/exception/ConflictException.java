package com.macys.common.pricing.services.api.exception;

public class ConflictException extends Exception {

    private static final long serialVersionUID = 1L;

    public ConflictException(String errorMessage) {
        super(errorMessage);
    }

}
