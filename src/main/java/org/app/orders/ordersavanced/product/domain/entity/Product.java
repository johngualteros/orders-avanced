package org.app.orders.ordersavanced.product.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.app.orders.ordersavanced.product.domain.Description;
import org.app.orders.ordersavanced.product.domain.Name;
import org.app.orders.ordersavanced.product.domain.Price;
import org.app.orders.ordersavanced.product.domain.Stock;
import org.app.orders.ordersavanced.shared.domain.UuidValueObject;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private UuidValueObject id;
    private Name name;
    private Description description;
    private Price price;
    private Stock stock;

    public Product(final String name, final String description, Integer price, Integer stock) {
        this.id = new UuidValueObject();
        this.name = new Name(name);
        this.description = new Description(description);
        this.price = new Price(price);
        this.stock = new Stock(stock);
    }
}
