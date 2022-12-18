package com.ecomm.api.backend.service;

import com.ecomm.api.backend.entity.OrderEntity;
import com.ecommerce.api.model.NewOrder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public interface OrderService {
    Iterable<OrderEntity> getOrdersByCustomerID(@NotNull @Valid String customerID);
    Optional<OrderEntity> addOrder(@Valid NewOrder newOrder);
    Optional<OrderEntity> getOrderById(String orderID);
}
