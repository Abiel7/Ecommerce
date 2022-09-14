package com.ecomm.api.backend.service;

import com.ecomm.api.backend.entity.AddressEntity;
import com.ecomm.api.backend.entity.CardEntity;
import com.ecomm.api.backend.entity.UserEntity;
import com.ecommerce.api.model.RefreshToken;
import com.ecommerce.api.model.SignedInUser;
import com.ecommerce.api.model.User;

import java.util.Optional;

public interface UserService {

    void deleteCustomerById(String id);

    Optional<Iterable<AddressEntity>> getAddressesByCustomerID(String id);

    Iterable<UserEntity> getAllCustomers();

    Optional<CardEntity> getCardByCustomerId(String id);

    Optional<UserEntity> getCustomerByID(String id);

    Optional<SignedInUser> createUser(User user);

    UserEntity findUserByUsername(String userName);

    SignedInUser getSignedUser(UserEntity userEntity);

    Optional<SignedInUser> getAccessToken(RefreshToken refreshToken);

    void removeRefreshToken(RefreshToken refreshToken);
}
