package com.ecomm.api.backend.service;

import com.ecomm.api.backend.entity.reactiveEntity.CartEntity;
import com.ecomm.api.backend.repository.CartRepository;
import com.ecomm.api.backend.repository.UserRepository;
import com.ecommerce.api.model.Item;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CartServiceImpl implements CartService {

    private CartRepository cartRepository;

    private UserRepository userRepository;


    private ItemServiceImpl itemService;

    public CartServiceImpl(CartRepository cartRepository, UserRepository userRepository, ItemServiceImpl itemService) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.itemService = itemService;
    }

    @Override
    public Flux<Item> addCartItemsByCustomerId(String customerId, Item item) {
        return null;
    }

    @Override
    public Flux<Item> addOrReplaceItemsByCustomerId(String customerId, Item item) {
        return null;
    }

    @Override
    public Mono<Void> deleteCart(String customerId) {
        return null;
    }

    @Override
    public Mono<Void> deleteItemFromCart(String customerId, String itemId) {
        return null;
    }

    @Override
    public Mono<CartEntity> getCartByCustomerId(String customerId) {
        return null;
    }

/*
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

 */


}



