package org.app.orders.ordersavanced.shared.domain;

public class UuidValueObject {
    private final String value;

    public UuidValueObject(String value) {
        this.value = value;
    }

    public UuidValueObject() {
        this.value = java.util.UUID.randomUUID().toString();
    }

    public String value() {
        return value;
    }
}
