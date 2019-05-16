package com.macys.common.pricing.services.api.exception;

/**
 * ERERestClientException - TODO What does this do
 *
 * @author z239824
 */
public class PriceRestClientException extends Exception {

    private static final long serialVersionUID = 1L;

    private ApiError error;

    /**
     * @param errorMessage
     */
    public PriceRestClientException(String errorMessage) {
        super(errorMessage);
    }

    /**
     * @param error
     */
    public PriceRestClientException(ApiError error) {
        super(error.getMessage());
        this.error = error;
    }

    /**
     * TODO Method description
     *
     * @return
     */
    public ApiError getEnclosedError() {
        return error;
    }
}
