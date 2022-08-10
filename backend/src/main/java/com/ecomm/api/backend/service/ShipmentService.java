package com.ecomm.api.backend.service;

import com.ecomm.api.backend.entity.ShipmentEntity;
import reactor.core.publisher.Flux;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public interface ShipmentService {
    Flux<ShipmentEntity> getShipmentByOrderId(@Min(value = 1L, message = "Invalid order ID.") String orderId);
}
