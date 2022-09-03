package com.ecomm.api.backend.controller;


import com.ecomm.api.backend.hateoas.CartRepresentation;
import com.ecomm.api.backend.service.CartService;
import com.ecommerce.api.CartApi;
import com.ecommerce.api.model.Cart;
import com.ecommerce.api.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CartsController implements CartApi {

    private static final Logger log = LoggerFactory.getLogger(CartsController.class);

    private CartService cartService;
    private CartRepresentation cartRepresentationAssembler;


    public CartsController(CartService cartService, CartRepresentation cartRepresentationAssembler) {
        this.cartService = cartService;
        this.cartRepresentationAssembler = cartRepresentationAssembler;
    }

    @Override
    public Mono<ResponseEntity<Flux<Item>>> addCartItemsByCustomerId(String customerId, Mono<Item> item, ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<ResponseEntity<Flux<Item>>> addOrReplaceItemsByCustomerId(String customerId, Mono<Item> item, ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<ResponseEntity<Void>> deleteCart(String customerId, ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<ResponseEntity<Void>> deleteItemFromCart(String customerId, String itemId, ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<ResponseEntity<Cart>> getCartByCustomerId(String customerId, ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<ResponseEntity<Flux<Item>>> getCartItemsByCustomerId(String customerId, ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<ResponseEntity<Item>> getCartItemsByItemId(String customerId, String itemId, ServerWebExchange exchange) {
        return null;
    }
}

