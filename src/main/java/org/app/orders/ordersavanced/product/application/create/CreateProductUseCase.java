package org.app.orders.ordersavanced.product.application.create;

import lombok.extern.slf4j.Slf4j;
import org.app.orders.ordersavanced.product.domain.entity.Product;
import org.app.orders.ordersavanced.product.infrastructure.model.PersistenceProduct;
import org.app.orders.ordersavanced.product.infrastructure.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CreateProductUseCase {
    private ProductRepository repository;

    @Autowired
    public CreateProductUseCase(ProductRepository repository) {
        this.repository = repository;
    }

    public PersistenceProduct execute(PersistenceProduct persistenceProduct) {
        try {
            repository.save(persistenceProduct);
            log.info("Product created: {}", persistenceProduct.toString());
            return persistenceProduct;
        } catch (Exception e) {
            log.error("Error creating product: {}", e.getMessage());
        }
        return null;
    }
}
