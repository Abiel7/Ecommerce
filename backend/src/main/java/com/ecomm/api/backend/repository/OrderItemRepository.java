package com.ecomm.api.backend.repository;

import com.ecomm.api.backend.entity.OrderItemEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


public interface OrderItemRepository extends ReactiveCrudRepository<OrderItemEntity, UUID> {
}
