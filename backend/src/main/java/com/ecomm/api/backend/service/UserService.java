package com.ecomm.api.backend.service;

import com.ecomm.api.backend.entity.AddressEntity;
import com.ecomm.api.backend.entity.CardEntity;
import com.ecomm.api.backend.entity.UserEntity;

import java.util.Optional;

public interface UserService {

    void deleteCustomerById(String id);

    Optional<Iterable<AddressEntity>> getAddressesByCustomerID(String id) ;

    Iterable<UserEntity> getAllCustomers();

    Optional<CardEntity> getCardByCustomerId(String id);


 }
