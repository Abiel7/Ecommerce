package com.ecomm.api.backend.service;

import com.ecomm.api.backend.entity.AfterReactiv.OrderEntity;
import com.ecommerce.api.model.NewOrder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface OrderService {
    Mono<OrderEntity> addOrder(@Valid Mono<NewOrder> newOrder);

    Mono<OrderEntity> updateMapping(@Valid OrderEntity orderEntity);

    Flux<OrderEntity> getOrdersByCustomerId(@NotNull @Valid String customerId);

    Mono<OrderEntity> getByOrderId(String id);
}
