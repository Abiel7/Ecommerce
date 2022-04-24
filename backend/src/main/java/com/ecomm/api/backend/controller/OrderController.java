package com.ecomm.api.backend.controller;

import com.ecomm.api.backend.hateoas.OrderRepresentation;
import com.ecomm.api.backend.service.OrderService;
import com.ecommerce.api.OrderApi;
import com.ecommerce.api.model.NewOrder;
import com.ecommerce.api.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RestController
public class OrderController implements OrderApi {
    private OrderService orderService;
    private final OrderRepresentation orderRepresentationAssembler;

    public OrderController(OrderService orderService, OrderRepresentation orderRepresentationAssembler) {
        this.orderService = orderService;
        this.orderRepresentationAssembler = orderRepresentationAssembler;
    }

    @Override
    public ResponseEntity<Order> addOrder(NewOrder newOrder) {
        return orderService.addOrder(newOrder)
                .map(orderRepresentationAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(notFound().build());
    }

    @Override
    public ResponseEntity<Order> getOrderById(String id) {
        return orderService.getOrderById(id).map(orderRepresentationAssembler::toModel).map(ResponseEntity::ok)
                .orElse(notFound().build());

    }

    @Override
    public ResponseEntity<List<Order>> getOrdersByCustomerID(@NotNull @Valid String customerId) {
        return OrderApi.super.getOrdersByCustomerID(customerId);
    }
}
