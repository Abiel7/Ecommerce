package com.ecomm.api.backend.repository;

import com.ecomm.api.backend.entity.reactiveEntity.AddressEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;


public interface AddressRepository extends ReactiveCrudRepository<AddressEntity, UUID> {
}
