package com.ecomm.api.backend.service;

import com.ecomm.api.backend.entity.AfterReactiv.AddressEntity;
import com.ecommerce.api.model.AddAddressReq;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;


public interface AddressService {

    Mono<AddressEntity> createAddress(Mono<AddAddressReq> addAddressReq);
    Mono<Void> deleteAddressById(String id);
    Mono<Void> deleteAddressByID(UUID id );

    Mono<AddressEntity> getAddressById(String id);
    Flux<AddressEntity> getAllAddresses();

}
