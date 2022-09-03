package com.ecomm.api.backend.hateoas;

import com.ecomm.api.backend.entity.reactiveEntity.CartEntity;
import com.ecommerce.api.model.Cart;
import org.springframework.hateoas.server.reactive.ReactiveRepresentationModelAssembler;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

//  convert domain objects into representation model
@Component
public class CartRepresentation implements ReactiveRepresentationModelAssembler<CartEntity, Cart> {

    @Override
    public Mono<Cart> toModel(CartEntity entity, ServerWebExchange exchange) {
        return null;
    }
}

