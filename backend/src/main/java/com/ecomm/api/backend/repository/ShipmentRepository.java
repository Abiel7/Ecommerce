package com.ecomm.api.backend.repository;

import com.ecomm.api.backend.entity.AfterReactiv.ShipmentEntity;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;
public interface ShipmentRepository extends ReactiveCrudRepository<ShipmentEntity, UUID> {
    @Query("SELECT s.* FROM ecom.order o,ecom.shipment s  where o.shipment_id = s.id and o.id = :id")
    Flux<ShipmentEntity> getShipmentByOrderId(String id);
}
