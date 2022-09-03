package com.ecomm.api.backend.controller;

import com.ecomm.api.backend.hateoas.AddressRepresentation;
import com.ecomm.api.backend.hateoas.CardRepresentation;
import com.ecomm.api.backend.hateoas.UserRepresentation;
import com.ecomm.api.backend.service.UserService;
import com.ecommerce.api.CustomerApi;
import com.ecommerce.api.model.Address;
import com.ecommerce.api.model.Card;
import com.ecommerce.api.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
public class CustomerController implements CustomerApi {

    private final AddressRepresentation addressRepresentationAssembler;
    private final CardRepresentation cardRepresentationAssembler;
    private UserService userService;
    private final UserRepresentation userRepresentationAssembler;


    public CustomerController(AddressRepresentation addressRepresentationAssembler, CardRepresentation cardRepresentationAssembler, UserService userService, UserRepresentation userRepresentationAssembler) {
        this.addressRepresentationAssembler = addressRepresentationAssembler;
        this.cardRepresentationAssembler = cardRepresentationAssembler;
        this.userService = userService;
        this.userRepresentationAssembler = userRepresentationAssembler;
    }

    @Override
    public Mono<ResponseEntity<Void>> deleteCustomerById(String id, ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<ResponseEntity<Flux<User>>> getAllCustomers(ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<ResponseEntity<Card>> getCardByCustomerId(String id, ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<ResponseEntity<Flux<Address>>> getCustomerAddressByID(String id, ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<ResponseEntity<User>> getCustomerByID(String id, ServerWebExchange exchange) {
        return null;
    }
}
