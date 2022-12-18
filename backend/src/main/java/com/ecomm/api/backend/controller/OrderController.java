package com.ecomm.api.backend.controller;

import com.ecomm.api.backend.hateoas.OrderRepresentation;
import com.ecomm.api.backend.service.OrderService;
import com.ecommerce.api.OrderApi;
import com.ecommerce.api.model.NewOrder;
import com.ecommerce.api.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class OrderController implements OrderApi {
    private OrderService orderService;
    private final OrderRepresentation orderRepresentationAssembler;

    public OrderController(OrderService orderService, OrderRepresentation orderRepresentationAssembler) {
        this.orderService = orderService;
        this.orderRepresentationAssembler = orderRepresentationAssembler;
    }

    @Override
    public Mono<ResponseEntity<Order>> addOrder(Mono<NewOrder> newOrder, ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<ResponseEntity<Order>> getOrderById(String id, ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<ResponseEntity<Flux<Order>>> getOrdersByCustomerID(String customerId, ServerWebExchange exchange) {
        return null;
    }
}
