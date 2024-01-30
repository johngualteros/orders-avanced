package org.app.orders.ordersavanced.product.domain.discount;

public interface StrategyDiscount {
    double applyDiscount(double originalPrice);
}
