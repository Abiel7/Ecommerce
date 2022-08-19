package com.ecomm.api.backend.service;

import com.ecomm.api.backend.entity.reactiveEntity.AddressEntity;
import com.ecomm.api.backend.repository.AddressRepository;
import com.ecommerce.api.model.AddAddressReq;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Mono<AddressEntity> createAddress(Mono<AddAddressReq> addAddressReq) {
        return null;
    }

    @Override
    public Mono<Void> deleteAddressById(String id) {
        addressRepository.deleteById(UUID.fromString(id));
        return Mono.empty();
    }

    @Override
    public Mono<Void> deleteAddressByID(UUID id) {
        return null;
    }

    @Override
    public Mono<AddressEntity> getAddressById(String id) {
        return addressRepository.findById(UUID.fromString(id));
    }

    @Override
    public Flux<AddressEntity> getAllAddresses() {
        return addressRepository.findAll();
    }


    private AddressEntity toEntity(AddAddressReq model) {
        AddressEntity entity = new AddressEntity();
        return entity.setNumber(model.getNumber()).setResidency(model.getResidency())
                .setStreet(model.getStreet()).setCity(model.getCity()).setState(model.getState())
                .setCountry(model.getCountry()).setPincode(model.getPostCode());
    }
}
