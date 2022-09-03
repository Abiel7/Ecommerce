package com.ecomm.api.backend.service;

import com.ecomm.api.backend.entity.reactiveEntity.ProductEntity;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Validated
public interface ProductService {
    @NotNull Flux<ProductEntity> getAllProducts();
    Mono<ProductEntity> getProduct(@Min(value = 1L, message = "Invalid product ID.") String id);


}
