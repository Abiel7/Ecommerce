package com.ecomm.api.backend.controller;


import com.ecomm.api.backend.entity.UserEntity;
import com.ecomm.api.backend.hateoas.CartRepresentation;
import com.ecomm.api.backend.repository.UserRepository;
import com.ecomm.api.backend.service.CartService;

import com.ecommerce.api.CartApi;
import com.ecommerce.api.model.Cart;
import com.ecommerce.api.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.ResponseEntity.accepted;
import static org.springframework.http.ResponseEntity.ok;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class CartsController implements CartApi {

     private static final Logger log = LoggerFactory.getLogger(CartsController.class);

     private CartService cartService;
     private CartRepresentation cartRepresentationAssembler;


     public  CartsController(CartService cartService,CartRepresentation cartRepresentationAssembler) {
          this.cartService = cartService;
          this.cartRepresentationAssembler = cartRepresentationAssembler;
    }

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
     public ResponseEntity<Cart> getCartByCustomerId(String customerId) {
          return ok(cartRepresentationAssembler.toModel(cartService.getCartByCustomerId(customerId)));
     }

     @Override
     public ResponseEntity<List<Item>> getCartItemsByCustomerId(String customerId) {
          return ok(cartService.getCartItemsByCustomerId(customerId));
     }

     @Override
     public ResponseEntity<Item> getCartItemsByItemId(String customerId, String itemId) {
          return  ok(cartService.getCartItemsByItemId(customerId,itemId));
     }





}

