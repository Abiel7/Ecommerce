package com.ecomm.api.backend.repository;

import com.ecomm.api.backend.entity.OrderEntity;
import com.ecommerce.api.model.NewOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepositoryExt  {
    Optional<OrderEntity> insert(NewOrder m); // insert new order
}
