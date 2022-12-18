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

    /**
     * create a new user and  add it to the database
     *
     * @param user
     * @return
     */
    Optional<SignedInUser> createUser(User user);

    /**
     * Finds and returns a user  based  on given username
     *
     * @param userName
     * @return
     */
    UserEntity findUserByUsername(String userName);

    /**
     * creates a new model instance of signedinuser that holds the refresh token access token userId  and username
     *
     * @param userEntity
     * @return
     */
    SignedInUser getSignedInUser(UserEntity userEntity);

    /**
     * Generates a new returns a new access token for a given valid refresh token
     *
     * @param refreshToken
     * @return
     */
    Optional<SignedInUser> getAccessToken(RefreshToken refreshToken);

    /**
     * Remove the refresh token from the database it is called when the user wants to sign out
     *
     * @param refreshToken
     */
    void removeRefreshToken(RefreshToken refreshToken);
}
