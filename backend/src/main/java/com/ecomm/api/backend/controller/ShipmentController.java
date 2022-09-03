package com.ecomm.api.backend.controller;

import com.ecomm.api.backend.hateoas.ShipmentRepresentation;
import com.ecomm.api.backend.service.ShipmentService;
import com.ecommerce.api.ShippingApi;
import com.ecommerce.api.model.Authorization;
import com.ecommerce.api.model.Shipment;
import com.ecommerce.api.model.ShippingReq;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ShipmentController implements ShippingApi {

    private ShipmentService shipmentService;
    private final ShipmentRepresentation shipmentRepresentationAssembly;

    public ShipmentController(ShipmentService shipmentService, ShipmentRepresentation shipmentRepresentationAssembly) {
        this.shipmentService = shipmentService;
        this.shipmentRepresentationAssembly = shipmentRepresentationAssembly;
    }


    @Override
    public Mono<ResponseEntity<Flux<Shipment>>> getShippingByOrderid(String id, ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<ResponseEntity<Authorization>> shipOrder(Mono<ShippingReq> shippingReq, ServerWebExchange exchange) {
        return null;
    }
}
