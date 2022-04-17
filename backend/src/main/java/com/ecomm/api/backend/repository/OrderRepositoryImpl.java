package com.ecomm.api.backend.repository;


import com.ecomm.api.backend.entity.CartEntity;
import com.ecomm.api.backend.entity.ItemEntity;
import com.ecomm.api.backend.entity.OrderEntity;
import com.ecomm.api.backend.entity.OrderItemEntity;
import com.ecomm.api.backend.exceptions.ResourceNotFoundException;
import com.ecomm.api.backend.service.ItemService;
import com.ecomm.api.backend.service.ItemServiceImpl;
import com.ecommerce.api.model.NewOrder;
import com.ecommerce.api.model.Order;
import org.springframework.stereotype.Repository;

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

@Repository
@Transactional
public class OrderRepositoryImpl implements OrderRepositoryExt  {

    @PersistenceContext
    private EntityManager entityManager;

    private ItemRepository itemRepository;
    private AddressRepository addressRepository;
    private CartRepository cartRepository;
    private OrderItemRepository orderItemRepository;
    private ItemService itemService;


    public OrderRepositoryImpl (EntityManager entityManager, ItemRepository itemRepository, AddressRepository addressRepository,
                                CartRepository cartRepository, OrderItemRepository orderItemRepository, ItemService itemService) {
        this.entityManager = entityManager;
        this.itemRepository = itemRepository;
        this.addressRepository = addressRepository;
        this.cartRepository = cartRepository;
        this.orderItemRepository = orderItemRepository;
        this.itemService = itemService;


    }

    /**
     *  fetch all items in the customers cart
     *  caluclate the total price of the items in the cart
     *  create new order
     *  save to the database
     *  remove items from cart  since cart items are part of the order
     *  save order and cart items
     *
     * @param newOrder
     * @return
     */
    @Override
    public Optional<OrderEntity> insert(NewOrder newOrder) {
        Iterable<ItemEntity> dbItems = itemRepository.findByCustomerId(newOrder.getCustomerId());
        List<ItemEntity> items = StreamSupport.stream(dbItems.spliterator(),false).collect(toList());
        if(items.size() <1 ) {
         throw new ResourceNotFoundException(String.format(" " +
                    "No items found for customer id %s cart "  , newOrder.getCustomerId()));
        }
        BigDecimal total = BigDecimal.ZERO;
        for(ItemEntity item : items) {
            total = (BigDecimal.valueOf(item.getQuantity()).multiply(item.getPrice())).add(total);
        }

        Timestamp orderDate = Timestamp.from(Instant.now());
        entityManager.createNativeQuery("""
        INSERT INTO ecomm.orders (address_id, card_id, customer_id, order_date, total, status)
        VALUES(?, ?, ?, ?, ?, ?)
        """)
                .setParameter(1, newOrder.getAddress().getId())
                .setParameter(2, newOrder.getCard().getId())
                .setParameter(3, newOrder.getCustomerId())
                .setParameter(4, orderDate)
                .setParameter(5, total)
                .setParameter(6, Order.StatusEnum.CREATED.getValue())
                .executeUpdate();
        Optional<CartEntity> oCart = cartRepository.findByCustomerId(UUID.fromString(newOrder.getCustomerId()));
        CartEntity cart = oCart.orElseThrow(() -> new ResourceNotFoundException(String.format("Cart not found for given customer (ID: %s)", newOrder.getCustomerId())));
        itemRepository.deleteCartItemJoinById(cart.getItems().stream().map(i -> i.getId()).collect(toList()), cart.getId());
        OrderEntity entity = (OrderEntity) entityManager.createNativeQuery("""
        SELECT o.* FROM ecomm.orders o WHERE o.customer_id = ? AND o.order_date >= ?
        """, OrderEntity.class)
                .setParameter(1, newOrder.getCustomerId())
                .setParameter(2, OffsetDateTime.ofInstant(orderDate.toInstant(), ZoneId.of("Z")).truncatedTo(
                        ChronoUnit.MICROS))
                .getSingleResult();
        orderItemRepository.saveAll(cart.getItems().stream().map(i -> new OrderItemEntity()
                .setOrderId(entity.getId()).setItemId(i.getId())).collect(toList()));

        return Optional.of(entity);
    }

}
