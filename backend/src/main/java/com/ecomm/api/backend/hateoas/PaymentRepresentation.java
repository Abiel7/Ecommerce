package com.ecomm.api.backend.hateoas;

import com.ecomm.api.backend.entity.reactiveEntity.PaymentEntity;
import com.ecommerce.api.model.Payment;
import org.springframework.hateoas.server.reactive.ReactiveRepresentationModelAssembler;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class PaymentRepresentation implements ReactiveRepresentationModelAssembler<PaymentEntity, Payment> {
    @Override
    public Mono<Payment> toModel(PaymentEntity entity, ServerWebExchange exchange) {
        return null;
    }
}
