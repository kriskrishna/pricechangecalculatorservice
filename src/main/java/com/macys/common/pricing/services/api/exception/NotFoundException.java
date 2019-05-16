package com.macys.common.pricing.services.api.exception;

import lombok.Generated;

@Generated
public class NotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public NotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
