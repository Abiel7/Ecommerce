package com.ecomm.api.backend.controller;


import com.ecomm.api.backend.service.CartService;

import com.ecommerce.api.CartApi;
import com.ecommerce.api.model.Cart;
import com.ecommerce.api.model.Item;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.ResponseEntity.accepted;
import static org.springframework.http.ResponseEntity.ok;
import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;
@RestController
public class CartsController implements CartApi {

     private static final Logger log = LoggerFactory.getLogger(CartsController.class);

     private CartService cartService;

     @Override
     public ResponseEntity<List<Item>> addCartItemsByCustomerId(String customerId, Item item) {
          return ok(cartService.addCartItemsByCustomerId(customerId, item));
     }

     @Override
     public ResponseEntity<List<Item>> addOrReplaceItemsByCustomerId(String customerId, @Valid Item item) {
          return  ok(cartService.addOrReplaceItemsByCustomerId(customerId, item));
     }

     @Override
     public ResponseEntity<Void> deleteCart(String customerId) {
          cartService.deleteCart(customerId);
          return accepted().build();
     }

     @Override
     public ResponseEntity<Void> deleteItemFromCart(String customerId, String itemId) {
          cartService.deleteItemFromCart(customerId, itemId);
          return accepted().build();

     }

     @Override
     public ResponseEntity<List<Cart>> getCartByCustomerId(String customerId) {
          return null;
     }

     @Override
     public ResponseEntity<List<Item>> getCartItemsByCustomerId(String customerId) {
          return ok(cartService.getCartItemsByCustomerId(customerId));
     }

     @Override
     public ResponseEntity<List<Item>> getCartItemsByItemId(String customerId, String itemId) {
          return  null ;//ok(cartService.getCartItemsByItemId(customerId, itemId));
     }

     // test  mapping
     @GetMapping(value="/hello", produces = MediaType.TEXT_PLAIN_VALUE)
     public ResponseEntity<String> test() {
          return ok("test");
     }
}

