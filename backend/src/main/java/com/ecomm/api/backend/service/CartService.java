package com.ecomm.api.backend.service;

import com.ecomm.api.backend.entity.CartEntity;
import com.ecommerce.api.model.Item;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

/**
 *  all the methods should serve the methods in cartController class
 */
@Service
public interface CartService {

 List<Item> addCartItemsByCustomerId(String customerId, @Valid Item item);

 List<Item> addOrReplaceItemsByCustomerId(String customerId, @Valid Item item);

 void deleteCart(String customerId);

 void deleteItemFromCart(String customerId, String itemId);
 CartEntity getCartByCustomerId(String customerId);

 List<Item> getCartItemsByCustomerId(String customerId);

 Item getCartItemsByItemId(String customerId, String itemId);


}
