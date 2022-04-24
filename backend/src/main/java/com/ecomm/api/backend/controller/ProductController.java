package com.ecomm.api.backend.controller;

import com.ecomm.api.backend.hateoas.ProductRepresentation;
import com.ecomm.api.backend.repository.ProductRepository;
import com.ecomm.api.backend.service.PaymentService;
import com.ecomm.api.backend.service.ProductService;
import com.ecommerce.api.ProductApi;
import com.ecommerce.api.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.notFound;

@RestController
public class ProductController implements ProductApi {

    private ProductService productService;
    private final ProductRepresentation productRepresentationAssembler;
    private ProductRepository productRepository;

    public ProductController(ProductService paymentService, ProductRepresentation productRepresentationAssembler , ProductRepository productRepository) {
        this.productService = paymentService;
        this.productRepresentationAssembler = productRepresentationAssembler;
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<Product> getProduct(String id) {
        return productService.getProduct(id)
                .map(productRepresentationAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(notFound().build());

    }

    @Override
    public ResponseEntity<List<Product>> queryProducts(@Valid String tag,@Valid String name, @Valid Integer page,@Valid Integer size) {
        return ok(productRepresentationAssembler.toListModel(productService.getAllProducts()));
    }
@GetMapping("/api/v2/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ok(productRepresentationAssembler.toListModel(productRepository.findAll()));


    }
}
