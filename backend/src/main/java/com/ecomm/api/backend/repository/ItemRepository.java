package com.ecomm.api.backend.repository;

import com.ecomm.api.backend.entity.AfterReactiv.ItemEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import java.util.List;
import java.util.UUID;



public interface ItemRepository extends ReactiveCrudRepository<ItemEntity, UUID> {
    @Query(value = "select i.* from ecomm.cart c, ecomm.item i, ecomm.user u, ecomm.cart_item ci where u.id = :customerId and c.user_id=u.id and c.id=ci.cart_id and i.id=ci.item_id")
    Flux<ItemEntity> findByCustomerId(String customerId);

    @Modifying
    @Query(value = "delete from ecomm.cart_item where item_id in (:ids) and cart_id = :cartId")
    Mono<Void> deleteCartItemJoinById(List<UUID> ids, UUID cartId);


    @Query("delete from ecomm.cart_item where cart_id in (:cartId)")
    Mono<Void> deleteByIds(List<String> cartId );

    @Query(value = "insert into ecomm.cart_item(cart_id,item_id) values (:cartId,:itemId)")
    Mono<Void>  saveItems(String cartId, String itemId);
}