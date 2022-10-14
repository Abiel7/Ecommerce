package com.ecomm.api.backend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "user_token")
public class UserTokenEntity {
    @Id
    @GeneratedValue
    @Column(name = "ID", updatable = false, nullable = false)
    private UUID id;

    @NotNull(message = "Refresh Token is required")
    @Basic(optional = true)
    @Column(name = "refresh_token")
    private String refreshToken;


    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;

    public UUID getId() {
        return id;
    }

    public UserTokenEntity setId(UUID id, UserEntity userEntity, String refreshToken) {

        this.id = id;
        this.user = userEntity;
        this.refreshToken = refreshToken;
        return this;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public UserTokenEntity setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public UserTokenEntity setUser(UserEntity userEntity) {
        this.user = userEntity;
        return this;
    }
}
