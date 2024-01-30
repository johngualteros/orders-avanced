package org.app.orders.ordersavanced.product.infrastructure.factories;

import org.app.orders.ordersavanced.product.domain.entity.Product;
import org.app.orders.ordersavanced.product.infrastructure.model.PersistenceProduct;

public final class ProductFactory {
    public static PersistenceProduct create(Product product) {
        return new PersistenceProduct(
                product.getId().value(),
                product.getName().value(),
                product.getDescription().value(),
                product.getPrice().value(),
                product.getStock().value()
        );
    }
}
