package org.app.orders.ordersavanced.product.infrastructure.presentation;

import lombok.extern.slf4j.Slf4j;
import org.app.orders.ordersavanced.product.application.create.CreateProductRequest;
import org.app.orders.ordersavanced.product.application.create.CreateProductUseCase;
import org.app.orders.ordersavanced.product.domain.entity.Product;
import org.app.orders.ordersavanced.product.infrastructure.factories.ProductFactory;
import org.app.orders.ordersavanced.shared.domain.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/product/create")
public class CreateProductRestController {

    private final CreateProductUseCase createProductUseCase;

    @Autowired
    public CreateProductRestController(CreateProductUseCase createProductUseCase) {
        this.createProductUseCase = createProductUseCase;
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody CreateProductRequest request) {
        log.info("CreateProductRestController.createProduct: {}", request.toString());
        Product product = new Product(request.getName(), request.getDescription(), request.getPrice(), request.getStock());
        createProductUseCase.execute(ProductFactory.create(product));
        HttpResponse httpResponse = new HttpResponse(request, "Product created");
        return ResponseEntity.ok(httpResponse);
    }

}
