package org.app.orders.ordersavanced.product.application.create;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class CreateProductRequest {
    private String name;
    private String description;
    private Integer price;
    private Integer stock;

    public CreateProductRequest() {
        this(null, null, 0 , 0);
    }
}
