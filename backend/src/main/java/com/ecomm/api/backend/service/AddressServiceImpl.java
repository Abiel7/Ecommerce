package com.ecomm.api.backend.service;

import com.ecomm.api.backend.entity.AddressEntity;
import com.ecomm.api.backend.repository.AddressRepository;
import com.ecommerce.api.model.AddAddressReq;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Optional<AddressEntity> createAddress(AddAddressReq addAddressReq) {
        return Optional.of(addressRepository.save(toEntity(addAddressReq)));
    }

    @Override
    public void deleteAddressById(String id) {
        addressRepository.deleteById(UUID.fromString(id));

    }

    @Override
    public Optional<AddressEntity> getAddressById(String id) {
        return addressRepository.findById(UUID.fromString(id));
    }

    @Override
    public Iterable<AddressEntity> getAllAddresses() {
        return addressRepository.findAll();
    }


    private AddressEntity toEntity(AddAddressReq model) {
        AddressEntity entity = new AddressEntity();
        return entity.setNumber(model.getNumber()).setResidency(model.getResidency())
                .setStreet(model.getStreet()).setCity(model.getCity()).setState(model.getState())
                .setCountry(model.getCountry()).setPincode(model.getPostCode());
    }
}
