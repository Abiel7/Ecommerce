package com.ecomm.api.backend.service;

import com.ecomm.api.backend.entity.AddressEntity;
import com.ecommerce.api.model.AddAddressReq;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface AddressService {

    Optional<AddressEntity> createAddress(AddAddressReq addAddressReq);
    void deleteAddressById(String id);
    Optional<AddressEntity> getAddressById(String id);
    public Iterable<AddressEntity> getAllAddresses();

}
