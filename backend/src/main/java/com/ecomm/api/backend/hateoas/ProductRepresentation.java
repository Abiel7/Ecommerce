package com.ecomm.api.backend.hateoas;

import com.ecomm.api.backend.entity.reactiveEntity.ProductEntity;
import com.ecommerce.api.model.Product;
import org.springframework.hateoas.server.reactive.ReactiveRepresentationModelAssembler;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class ProductRepresentation implements ReactiveRepresentationModelAssembler<ProductEntity, Product> {


    @Override
    public Mono<Product> toModel(ProductEntity entity, ServerWebExchange exchange) {
        return null;
    }
}
