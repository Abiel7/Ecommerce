package com.ecomm.api.backend.service;

import com.ecomm.api.backend.entity.AddressEntity;
import com.ecomm.api.backend.entity.CardEntity;
import com.ecomm.api.backend.entity.UserEntity;
import com.ecomm.api.backend.repository.UserRepository;
import com.ecommerce.api.model.RefreshToken;
import com.ecommerce.api.model.SignedInUser;
import com.ecommerce.api.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;


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
        return userRepository.findAll();
    }

    @Override
    public Optional<CardEntity> getCardByCustomerId(String id) {
        AtomicReference<Optional<CardEntity>> cardEntityAtomicReference = new AtomicReference<>(Optional.empty());
        userRepository.findById(UUID.fromString(id)).ifPresent(userEntity -> {


                    if (Objects.nonNull(userEntity.getCard()) && userEntity.getCard().isEmpty()) {
                        cardEntityAtomicReference.set(Optional.of(userEntity.getCard().get(0)));
                    }
                }
        );
        return cardEntityAtomicReference.get();
    }

    @Override
    public Optional<UserEntity> getCustomerByID(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<SignedInUser> createUser(User user) {
        return Optional.empty();
    }

    @Override
    public UserEntity findUserByUsername(String userName) {
        return null;
    }

    @Override
    public SignedInUser getSignedUser(UserEntity userEntity) {
        return null;
    }

    @Override
    public Optional<SignedInUser> getAccessToken(RefreshToken refreshToken) {
        return Optional.empty();
    }

    @Override
    public void removeRefreshToken(RefreshToken refreshToken) {

    }
}
