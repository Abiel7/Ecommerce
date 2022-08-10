package com.ecomm.api.backend.repository;


import com.ecomm.api.backend.entity.CartEntity;
import com.ecomm.api.backend.entity.ItemEntity;
import com.ecomm.api.backend.entity.OrderEntity;
import com.ecomm.api.backend.entity.OrderItemEntity;
import com.ecomm.api.backend.exceptions.ResourceNotFoundException;
import com.ecomm.api.backend.service.CartService;
import com.ecomm.api.backend.service.ItemService;
import com.ecomm.api.backend.service.ItemServiceImpl;
import com.ecommerce.api.model.NewOrder;
import com.ecommerce.api.model.Order;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

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
   private DatabaseClient databaseClient;
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
            this.databaseClient = databaseClient;
   }
    private OrderEntity toEntity(NewOrder order, CartEntity cartEntity) {
       OrderEntity orderEntity = new OrderEntity();

        BeanUtils.copyProperties(order, orderEntity);
        orderEntity.setUserEntity(cartEntity.getUser());
        orderEntity.setCartId(cartEntity.getId());
    }
    @Override
    public Mono<OrderEntity> insert(NewOrder m) {
        return null;
    }

    @Override
    public Mono<OrderEntity> updateMapping(OrderEntity m) {
        return null;
    }
}
