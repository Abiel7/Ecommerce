package com.ecomm.api.backend.service;

import com.ecomm.api.backend.entity.AddressEntity;
import com.ecomm.api.backend.entity.CardEntity;
import com.ecomm.api.backend.entity.UserEntity;
import com.ecomm.api.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void deleteCustomerById(String id) {
        userRepository.deleteById(UUID.fromString(id));

    }

    @Override
    public Optional<Iterable<AddressEntity>> getAddressesByCustomerID(String id) {
        return userRepository.findById(UUID.fromString(id)).map(UserEntity::getAddresses);
    }

    @Override
    public Iterable<UserEntity> getAllCustomers() {
        return  userRepository.findAll();
    }

    @Override
    public Optional<CardEntity> getCardByCustomerId(String id) {
        AtomicReference<Optional<CardEntity>> cardEntityAtomicReference = new AtomicReference<>(Optional.empty());
        userRepository.findById(UUID.fromString(id)).ifPresent(userEntity -> {


            if(Objects.nonNull(userEntity.getCard()) && userEntity.getCard().isEmpty()) {
                cardEntityAtomicReference.set(Optional.of(userEntity.getCard().get(0)));
            }
        }
        );
        return cardEntityAtomicReference.get();
    }
}
