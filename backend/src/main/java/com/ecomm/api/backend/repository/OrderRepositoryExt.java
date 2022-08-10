package com.ecomm.api.backend.repository;

import com.ecomm.api.backend.entity.OrderEntity;
import com.ecommerce.api.model.NewOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepositoryExt  {
    Mono<OrderEntity> insert(NewOrder m); // insert new order

    // update mapping
    Mono<OrderEntity> updateMapping(OrderEntity m);
}
