package org.app.orders.ordersavanced.shared.domain;

public abstract class IntegerValueObject {
    private final Integer value;

    public IntegerValueObject(Integer value) {
        this.value = value;
    }

    public Integer value() {
        return value;
    }
}
