package org.app.orders.ordersavanced.shared.domain;

public abstract class StringValueObject {
    private final String value;

    public StringValueObject(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
