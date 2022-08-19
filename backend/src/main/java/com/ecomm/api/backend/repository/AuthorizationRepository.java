package com.ecomm.api.backend.repository;

import com.ecomm.api.backend.entity.reactiveEntity.AuthorizationEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;


public interface AuthorizationRepository extends ReactiveCrudRepository<AuthorizationEntity, UUID> {
}
