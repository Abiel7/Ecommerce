package com.ecomm.api.backend.hateoas;

import com.ecomm.api.backend.entity.reactiveEntity.CardEntity;
import com.ecommerce.api.model.Card;
import org.springframework.hateoas.server.reactive.ReactiveRepresentationModelAssembler;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class CardRepresentation implements ReactiveRepresentationModelAssembler<CardEntity, Card> {


    @Override
    public Mono<Card> toModel(CardEntity entity, ServerWebExchange exchange) {
        return null;
    }
}
