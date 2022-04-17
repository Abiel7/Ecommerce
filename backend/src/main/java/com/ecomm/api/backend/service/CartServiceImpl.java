package com.ecomm.api.backend.service;

import com.ecomm.api.backend.entity.CartEntity;
import com.ecomm.api.backend.entity.ItemEntity;
import com.ecomm.api.backend.exceptions.CustomerNotFoundException;
import com.ecomm.api.backend.exceptions.GenericAlreadyExistsException;
import com.ecomm.api.backend.exceptions.ItemNotFoundException;
import com.ecomm.api.backend.repository.CartRepository;
import com.ecomm.api.backend.repository.UserRepository;
import com.ecommerce.api.CustomerApi;
import com.ecommerce.api.model.Cart;
import com.ecommerce.api.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.stream.Collectors.toList;
import static org.springframework.objenesis.instantiator.util.UnsafeUtils.getUnsafe;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired

    private ItemServiceImpl itemService;

    public CartServiceImpl(CartRepository cartRepository, UserRepository userRepository, ItemServiceImpl itemService) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.itemService = itemService;
    }


    @Override
    public List<Item> addCartItemsByCustomerId(String customerId, Item item) {
       CartEntity entity = getCartByCustomerId(customerId);
       long  count = entity.getItems().stream().filter(i -> i.getId().equals(UUID.fromString(item.getItemId()))).count();
       if(count > 0) {
           throw new GenericAlreadyExistsException(String.format("Item with id %s already exists in cart", item.getItemId()));
       }
       entity.getItems().add(itemService.toEntity(item));
       return itemService.toModelList(cartRepository.save(entity).getItems());
    }



    @Override
    public List<Item> addOrReplaceItemsByCustomerId(String customerId, Item item) {
        return null;
    }

    @Override
    public void deleteCart(String customerId) {
        CartEntity entity = getCartByCustomerId(customerId);
        cartRepository.deleteById(entity.getId());

    }

    @Override
    public void deleteItemFromCart(String customerId, String itemId) {
        CartEntity entity = getCartByCustomerId(customerId);
        List<ItemEntity> updateItems = entity.getItems().stream().filter(i -> !i.getProduct().getId().equals(UUID.fromString(itemId))).collect(toList());
        entity.setItems(updateItems);
        cartRepository.save(entity);

    }

    @Override
    public CartEntity getCartByCustomerId(String customerId) {
        CartEntity entity = cartRepository.findByCustomerId(UUID.fromString(customerId)).orElse(new CartEntity());
    if(Objects.isNull(entity.getUser())) {
        entity.setUser(userRepository.findById(UUID.fromString(customerId))
                .orElseThrow(() -> new CustomerNotFoundException(String.format("Customer with id %s not found", customerId))));
    }
        return entity;
    }

    @Override
    public List<Item> getCartItemsByCustomerId(String customerId) {
        CartEntity entity = getCartByCustomerId(customerId);
        return itemService.toModelList(entity.getItems());
    }

    @Override
    public Item getCartItemsByItemId(String customerId, String itemId) {
        CartEntity entity = getCartByCustomerId(customerId);
        AtomicReference<ItemEntity> itemEntiy = new AtomicReference<>();
        entity.getItems().forEach(i -> {
            if(i.getProduct().getId().equals(UUID.fromString(itemId))) {
                itemEntiy.set(i);;
            }
        });

        if(Objects.isNull(itemEntiy.get())){
            getUnsafe().throwException( new ItemNotFoundException(String.format("Item with id %s not found", itemId)));
        }


        return itemService.toModel(itemEntiy.get());

    }


}



