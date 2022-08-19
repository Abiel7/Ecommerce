package com.ecomm.api.backend.service;

import com.ecomm.api.backend.entity.reactiveEntity.ShipmentEntity;
import reactor.core.publisher.Flux;

import javax.validation.constraints.Min;

public interface ShipmentService {
    Flux<ShipmentEntity> getShipmentByOrderId(@Min(value = 1L, message = "Invalid order ID.") String orderId);
}
