package com.ecomm.api.backend.repository;

import com.ecomm.api.backend.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<UserEntity, UUID> {
}
