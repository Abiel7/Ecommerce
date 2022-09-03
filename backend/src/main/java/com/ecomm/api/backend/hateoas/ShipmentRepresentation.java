package com.ecomm.api.backend.hateoas;

import com.ecomm.api.backend.entity.reactiveEntity.ShipmentEntity;
import com.ecommerce.api.model.Shipment;
import org.springframework.hateoas.server.reactive.ReactiveRepresentationModelAssembler;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class ShipmentRepresentation implements ReactiveRepresentationModelAssembler<ShipmentEntity, Shipment> {


    @Override
    public Mono<Shipment> toModel(ShipmentEntity entity, ServerWebExchange exchange) {
        return null;
    }
}
