package org.app.orders.ordersavanced.shared.domain;

public class HttpResponse<T> {
    private T data;
    private String message;
    public HttpResponse() {
    }
    public HttpResponse(T data, String message) {
        this.data = data;
        this.message = message;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
