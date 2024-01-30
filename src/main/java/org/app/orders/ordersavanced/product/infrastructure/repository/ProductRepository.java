package org.app.orders.ordersavanced.product.infrastructure.repository;

import org.app.orders.ordersavanced.product.infrastructure.model.PersistenceProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<PersistenceProduct, String> {
}
