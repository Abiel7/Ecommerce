package com.ecomm.api.backend.service;

import com.ecomm.api.backend.entity.AddressEntity;
import com.ecomm.api.backend.repository.AddressRepository;
import com.ecommerce.api.model.AddAddressReq;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Optional<AddressEntity> createAddress(AddAddressReq addAddressReq) {
        return Optional.empty();
    }

    @Override
    public void deleteAddressById(String id) {

    }

    @Override
    public Optional<AddressEntity> getAddressById(String id) {
        return Optional.empty();
    }

    @Override
    public Iterable<AddressEntity> getAllAddresses() {
        return addressRepository.findAll();
    }
}
