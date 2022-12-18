package com.ecomm.api.backend.controller;

import com.ecommerce.api.UsersApi;
import com.ecommerce.api.model.SignedInUser;
import com.ecommerce.api.model.User;
import org.springframework.http.ResponseEntity;

public class AuthController implements UsersApi {

    @Override
    public ResponseEntity<SignedInUser> signUp(User user) {
        return null;
    }
}
