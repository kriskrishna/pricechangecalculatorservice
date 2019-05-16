package com.macys.common.pricing.services.api.exception;

import lombok.Generated;

@Generated
public class BadRequestException extends Exception {

    private static final long serialVersionUID = 1L;

    public BadRequestException(String errorMessage) {
        super(errorMessage);
    }

}
