package com.ecomm.api.backend.service;

import com.ecomm.api.backend.entity.ShipmentEntity;
import com.ecomm.api.backend.repository.ShipmentRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ShipmentServiceImpl implements ShipmentService {
    private ShipmentRepository shipmentRepository;;

    public ShipmentServiceImpl(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    @Override
    public Iterable<ShipmentEntity> getShipmentByOrderId(@NotNull @Valid  String orderId) {
        return shipmentRepository.findAllById(List.of(UUID.fromString(orderId)));
    }
}
