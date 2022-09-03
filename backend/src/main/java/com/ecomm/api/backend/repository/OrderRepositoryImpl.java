package com.ecomm.api.backend.repository;


import com.ecomm.api.backend.entity.reactiveEntity.CartEntity;
import com.ecomm.api.backend.entity.reactiveEntity.OrderEntity;
import com.ecomm.api.backend.service.CartService;
import com.ecommerce.api.model.NewOrder;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import  java.util.stream.Collectors;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;


/**
 * The persistence context is just a synchronizer object that tracks the state of a
 * limited set of Java objects and makes sure that changes on those objects are eventually
 * persisted back into the database.
 * by tagging  this class with @Transactional,  it is referring to database transaction atomicity, consistency, isolation, durability (ACID)
 */
@Repository
//@Transactional
public class OrderRepositoryImpl implements OrderRepositoryExt  {

   private ConnectionFactory connectionFactory;
   private DatabaseClient dbaseClient;
   private ItemRepository itemRepository;
   private CartService cartService;
   private OrderItemRepository orderItemRepository;

   public  OrderRepositoryImpl( ConnectionFactory connectionFactory,
                                ItemRepository itemRepository,
                                OrderItemRepository orderItemRepository,
                                CartService cartService,
                                DatabaseClient databaseClient) {

            this.connectionFactory = connectionFactory;
            this.itemRepository = itemRepository;
            this.orderItemRepository = orderItemRepository;
            this.cartService = cartService;
            this.dbaseClient = databaseClient;
   }
    private OrderEntity toEntity(NewOrder order, CartEntity cartEntity) {
       OrderEntity orderEntity = new OrderEntity();
        /*
        populating orderEntity
        https://www.logicbig.com/tutorials/spring-framework/spring-core/bean-utils-copy-properties.html
         */
        BeanUtils.copyProperties(order, orderEntity);
        orderEntity.setUserEntity(cartEntity.getUser());
        orderEntity.setCardId(cartEntity.getId());
        orderEntity.setCartId(cartEntity.getId())
                .setCustomerId(UUID.fromString(order.getCustomerId()))
                .setAddressId(UUID.fromString(order.getAddress().getId()))
                .setOrderDate(Timestamp.from(Instant.now()))
                .setTotal(cartEntity.getItems().stream().collect(
                        Collectors.toMap(k -> k.getProductId(),v -> BigDecimal.valueOf(v.get))));
        return null;
    }
    @Override
    public Mono<OrderEntity> insert(Mono<NewOrder> m) {

        return null;
    }

    @Override
    public Mono<OrderEntity> updateMapping(OrderEntity m) {
        return null;
    }
}
