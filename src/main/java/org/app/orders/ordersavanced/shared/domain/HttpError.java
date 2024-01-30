package org.app.orders.ordersavanced.shared.domain;

public class HttpError {

    private String errorMessage;

    public HttpError() {
    }

    public HttpError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
