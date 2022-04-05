package com.ecomm.api.backend.repository;


import com.ecomm.api.backend.entity.ItemEntity;
import com.ecomm.api.backend.entity.OrderEntity;
import com.ecomm.api.backend.service.ItemService;
import com.ecommerce.api.model.NewOrder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

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


    public OrderRepositoryImpl (EntityManager entityManager,ItemRepository itemRepository,AddressRepository addressRepository,
                                CartRepository cartRepository,OrderItemRepository orderItemRepository,ItemService itemService) {
        this.entityManager = entityManager;
        this.itemRepository = itemRepository;
        this.addressRepository = addressRepository;
        this.cartRepository = cartRepository;
        this.orderItemRepository = orderItemRepository;
        this.itemService = itemService;


    }

    @Override
    public Optional<OrderEntity> insert(NewOrder m) {
        Iterable<ItemEntity> items = itemRepository.findByCustomerId(m.getCustomerId());
        

        return Optional.empty(); //TODO
    }

}
