package com.ecomm.api.backend.repository;

import com.ecomm.api.backend.entity.CardEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CardRepository extends CrudRepository<CardEntity, UUID> {
}
