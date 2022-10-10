package com.ecomm.api.backend.service;

import com.ecomm.api.backend.entity.ShipmentEntity;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public interface ShipmentService {
    Iterable<ShipmentEntity> getShipmentByOrderId(@NotNull @Valid String orderId);
}
