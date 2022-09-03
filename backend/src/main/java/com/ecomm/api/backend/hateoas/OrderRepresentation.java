package com.ecomm.api.backend.hateoas;

import com.ecomm.api.backend.entity.reactiveEntity.OrderEntity;
import com.ecomm.api.backend.service.ItemService;
import com.ecommerce.api.model.Order;
import org.springframework.hateoas.server.reactive.ReactiveRepresentationModelAssembler;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class OrderRepresentation implements ReactiveRepresentationModelAssembler<OrderEntity, Order> {

    private UserRepresentation userRepresentation;
    private AddressRepresentation addressRepresentation;
    private CardRepresentation cardRepresentation;
    private ShipmentRepresentation shipmentRepresentation;
    private ItemService itemService;

    public OrderRepresentation(UserRepresentation userRepresentation,
                               AddressRepresentation addressRepresentation,
                               CardRepresentation cardRepresentation,
                               ShipmentRepresentation shipmentRepresentation,
                               ItemService itemService) {

        this.userRepresentation = userRepresentation;
        this.addressRepresentation = addressRepresentation;
        this.cardRepresentation = cardRepresentation;
        this.shipmentRepresentation = shipmentRepresentation;
        this.itemService = itemService;
    }

    @Override
    public Mono<Order> toModel(OrderEntity entity, ServerWebExchange exchange) {
        return null;
    }
}
