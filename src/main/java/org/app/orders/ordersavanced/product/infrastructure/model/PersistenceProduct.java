package org.app.orders.ordersavanced.product.infrastructure.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.app.orders.ordersavanced.product.domain.discount.StrategyDiscount;

@Getter
@Setter
@Entity
@Table(name = "products")
public class PersistenceProduct {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Integer price;

    @Column(name = "stock")
    private Integer stock;

    @Transient
    private StrategyDiscount strategyDiscount;

    public double applyDiscount() {
        if (strategyDiscount == null) {
            return price;
        }
        return strategyDiscount.applyDiscount(this.price);
    }

    public PersistenceProduct() {
        this(null, null, null, 0, 0);
    }

    public PersistenceProduct(String id, String name, String description, Integer price, Integer stock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }
}
