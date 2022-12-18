package com.ecomm.api.backend.repository;

import com.ecomm.api.backend.entity.imperativeEntity.UserTokenEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserTokenRepository extends CrudRepository<UserTokenEntity, UUID> {
    Optional<UserTokenEntity> findByRefreshToken(String refreshToken);

    Optional<UserTokenEntity> deleteByUserID(UUID userID);
}
