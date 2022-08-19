package com.ecomm.api.backend.repository;

import com.ecomm.api.backend.entity.AfterReactiv.CardEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CardRepository extends ReactiveCrudRepository<CardEntity, UUID> {
}
