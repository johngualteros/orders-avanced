package org.app.orders.ordersavanced.product.application.discount;

import org.app.orders.ordersavanced.product.domain.discount.StrategyDiscount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class PercentDiscountUseCase implements StrategyDiscount {
    private double discountPercent;

    public PercentDiscountUseCase(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public double applyDiscount(double originalPrice) {
        return originalPrice * (1 - discountPercent / 100);
    }
}
