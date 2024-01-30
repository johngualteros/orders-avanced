package org.app.orders.ordersavanced.product.application.discount;

import org.app.orders.ordersavanced.product.domain.discount.StrategyDiscount;

public class FixedDiscountUseCase implements StrategyDiscount {
    private double discountAmount;

    public FixedDiscountUseCase(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public double applyDiscount(double originalPrice) {
        return originalPrice - discountAmount;
    }
}
