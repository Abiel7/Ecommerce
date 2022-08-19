package com.ecomm.api.backend.repository;

import com.ecomm.api.backend.entity.reactiveEntity.OrderEntity;
import com.ecommerce.api.model.NewOrder;
import reactor.core.publisher.Mono;

public interface OrderRepositoryExt  {
    Mono<OrderEntity> insert(Mono<NewOrder> newOrder); // insert new order

    // update mapping
    Mono<OrderEntity> updateMapping(OrderEntity order);
}
