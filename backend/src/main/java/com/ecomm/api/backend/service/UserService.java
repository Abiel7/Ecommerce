package com.ecomm.api.backend.service;

import com.ecomm.api.backend.entity.AfterReactiv.AddressEntity;
import com.ecomm.api.backend.entity.AfterReactiv.CardEntity;
import com.ecomm.api.backend.entity.AfterReactiv.UserEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface UserService {

    Mono<Void> deleteCustomerById(String id);
    Mono<Void> deleteCustomerByID(UUID id );

    Flux<AddressEntity> getAddressesByCustomerID(String id) ;

    Flux<UserEntity> getAllCustomers();

    Mono<CardEntity> getCardByCustomerId(String id);

    Mono<UserEntity> getCustomerById(String id);


 }
