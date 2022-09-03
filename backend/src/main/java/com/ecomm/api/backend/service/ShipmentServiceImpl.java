package com.ecomm.api.backend.service;

import com.ecomm.api.backend.entity.reactiveEntity.ShipmentEntity;
import com.ecomm.api.backend.repository.ShipmentRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ShipmentServiceImpl implements ShipmentService {
    private ShipmentRepository shipmentRepository;;

    public ShipmentServiceImpl(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    @Override
    public Flux<ShipmentEntity> getShipmentByOrderId(String orderId) {
        return shipmentRepository.getShipmentByOrderId(orderId);
    }

    /*
    before reactive approach
    @Override
    public Iterable<ShipmentEntity> getShipmentByOrderId(@NotNull @Valid  String orderId) {
        return shipmentRepository.findAllById(List.of(UUID.fromString(orderId)));
    }

     */
}
