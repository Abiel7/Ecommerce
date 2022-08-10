package com.ecomm.api.backend.service;

import com.ecomm.api.backend.entity.CardEntity;
import com.ecomm.api.backend.entity.CartEntity;
import com.ecommerce.api.model.Item;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.List;

/**
 *  all the methods should serve the methods in cartController class
 */
@Service
public interface CartService {

 Flux<Item> addCartItemsByCustomerId(String customerId, @Valid Item item);

 Flux<Item> addOrReplaceItemsByCustomerId(String customerId, @Valid Item item);

 Mono<Void> deleteCart(String customerId);

 Mono<Void>  deleteItemFromCart(String customerId, String itemId);

 Mono<CartEntity> getCartByCustomerId(String customerId);

 //CartEntity getCartByCustomerId(String customerId);

// List<Item> getCartItemsByCustomerId(String customerId);

 //Item getCartItemsByItemId(String customerId, String itemId);


}
