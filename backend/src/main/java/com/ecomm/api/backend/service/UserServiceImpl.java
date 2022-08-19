package com.ecomm.api.backend.service;

import com.ecomm.api.backend.entity.AfterReactiv.AddressEntity;
import com.ecomm.api.backend.entity.AfterReactiv.CardEntity;
import com.ecomm.api.backend.entity.AfterReactiv.UserEntity;
import com.ecomm.api.backend.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Mono<Void> deleteCustomerById(String id) {
        return deleteCustomerByID(UUID.fromString(id));
    }

    @Override
    public Mono<Void> deleteCustomerByID(UUID id) {
        return userRepository.deleteById(id).then();
    }

    @Override
    public Flux<AddressEntity> getAddressesByCustomerID(String id) {
        return userRepository.getAddressesByCustomerId(id);
    }

    @Override
    public Flux<UserEntity> getAllCustomers() {
        return userRepository.findAll();
    }

    @Override
    public Mono<CardEntity> getCardByCustomerId(String id) {
        return userRepository.findCardByCustomerId(id);
    }

    @Override
    public Mono<UserEntity> getCustomerById(String id) {
        return userRepository.findById(UUID.fromString(id));
    }

    /*
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

     */
}
