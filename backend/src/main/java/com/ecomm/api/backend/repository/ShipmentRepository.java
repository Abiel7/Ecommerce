package com.ecomm.api.backend.repository;

import com.ecomm.api.backend.entity.ShipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.UUID;
public interface ShipmentRepository extends ReactiveCrudRepository<ShipmentEntity, UUID> {
    @Query("SELECT s.* FROM ecom.order o,ecom.shipment s  where o.shipment_id = s.id and o.id = :id")
    Flux<ShipmentEntity> getShipmentByOrderId(String id);
}
