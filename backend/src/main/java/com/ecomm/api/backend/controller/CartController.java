package com.ecomm.api.backend.controller;

import com.ecommerce.api.CartApi;
import com.ecommerce.api.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

public class CartController implements CartApi {
    private static final Logger log = LoggerFactory.getLogger(CartController.class);

    @Override
    public ResponseEntity<List<Item>> addCartItemsByCustomerId(String customerId, @Valid Item item){
        log.info("Request for customre if {}\nItem: {} ",customerId,item);

        return ok(Collections.EMPTY_LIST);
    }
}

