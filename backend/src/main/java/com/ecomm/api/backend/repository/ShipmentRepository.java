package com.ecomm.api.backend.repository;

import com.ecomm.api.backend.entity.ShipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
public interface ShipmentRepository extends CrudRepository<ShipmentEntity, UUID> {
}
