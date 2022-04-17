package com.ecomm.api.backend.repository;

import com.ecomm.api.backend.entity.CartEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface CartRepository extends CrudRepository<CartEntity, UUID> {

    @Query("select c from CartEntity c join c.user u where u.id =:customerId")
    public Optional<CartEntity> findByCustomerId(@Param("customerId") UUID customerId);
}
