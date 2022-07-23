package com.ecomm.api.backend.repository;

import com.ecomm.api.backend.entity.CartEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.UUID;

public interface CartRepository extends ReactiveCrudRepository<CartEntity, UUID> {

    @Query("select c from CartEntity c join c.user u where u.id =:customerId")
    Mono<CartEntity> findByCustomerId(String customerId );
}
