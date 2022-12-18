package com.ecomm.api.backend.hateoas;

import com.ecomm.api.backend.entity.reactiveEntity.UserEntity;
import com.ecommerce.api.model.User;
import org.springframework.hateoas.server.reactive.ReactiveRepresentationModelAssembler;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class UserRepresentation implements ReactiveRepresentationModelAssembler<UserEntity, User> {


    @Override
    public Mono<User> toModel(UserEntity entity, ServerWebExchange exchange) {
        return null;
    }
}
