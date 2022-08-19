package com.ecomm.api.backend.repository;

import com.ecomm.api.backend.entity.AfterReactiv.OrderItemEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;


public interface OrderItemRepository extends ReactiveCrudRepository<OrderItemEntity, UUID> {
}
