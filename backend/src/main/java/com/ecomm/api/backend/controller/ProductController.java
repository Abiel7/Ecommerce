package com.ecomm.api.backend.controller;

import com.ecomm.api.backend.hateoas.ProductRepresentation;
import com.ecomm.api.backend.repository.ProductRepository;
import com.ecomm.api.backend.service.ProductService;
import com.ecommerce.api.ProductApi;
import com.ecommerce.api.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductController implements ProductApi {

    private ProductService productService;
    private final ProductRepresentation productRepresentationAssembler;
    private ProductRepository productRepository;

    public ProductController(ProductService paymentService, ProductRepresentation productRepresentationAssembler, ProductRepository productRepository) {
        this.productService = paymentService;
        this.productRepresentationAssembler = productRepresentationAssembler;
        this.productRepository = productRepository;
    }

    @Override
    public Mono<ResponseEntity<Product>> getProduct(String id, ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<ResponseEntity<Flux<Product>>> queryProducts(String tag, String name, Integer page, Integer size, ServerWebExchange exchange) {
        return null;
    }
}
