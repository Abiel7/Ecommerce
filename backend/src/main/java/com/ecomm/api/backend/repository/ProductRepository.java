package com.ecomm.api.backend.repository;

import com.ecomm.api.backend.entity.AfterReactiv.ProductEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface ProductRepository extends ReactiveCrudRepository<ProductEntity, UUID> {
}
