package com.ecomm.api.backend.controller;


import com.ecommerce.api.CartApi;
import com.ecommerce.api.model.Cart;
import com.ecommerce.api.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;
@RestController
public class CartController implements CartApi {

     private static final Logger log = LoggerFactory.getLogger(CartController.class);


    @Override
    public ResponseEntity<List<Item>> addItemsOnCartByCustomerId(String customerId, Item item) {
        log.info("Request for customre if {}\nItem: {} ",customerId,item);

        return ok(Collections.EMPTY_LIST);

    }

    @Override
    public ResponseEntity<List<Item>> addOrReplaceItemsByCustomerId(String customerId, Item item) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteCart(String customerId) {
        return null;
    }

    @Override
    public ResponseEntity<List<Cart>> getCartByCustomerId(String customerId) {
        return null;
    }

    @Override
    public ResponseEntity<List<Item>> getCartItemById(String customerId, String itemId) {
        return null;
    }

    @Override
    public ResponseEntity<List<Item>> getCartItemsByCutomerId(String customerId) {
        return null;
    }

    @Override
    public ResponseEntity<List<Item>> removeItemsById(String customerId, String itemId) {
        return null;
    }

}

