package com.ecomm.api.backend.security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Date;

import static com.ecomm.api.backend.security.Constants.EXPIRATION_TIME;
import static com.ecomm.api.backend.security.Constants.ROLE;
import static java.util.stream.Collectors.toList;


@Component
public class JwtManager {


    private RSAPrivateKey privateKey;

    private RSAPublicKey publicKey;

    public JwtManager(RSAPrivateKey privateKey, RSAPublicKey publicKey) {
        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }

    private String create(UserDetails userDetails) {
        final long now = System.currentTimeMillis();
        return JWT.create().
                withIssuer("Modern API Development with Spring and Spring Boot")
                .withSubject(userDetails.getUsername())
                .withClaim(ROLE,
                        userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                                .collect(toList()))
                .withIssuedAt(new Date(now))
                .withExpiresAt(new Date(now + EXPIRATION_TIME))
                .sign(Algorithm.RSA256(publicKey, privateKey));
    }


}
