package com.ecomm.api.backend.controller;

import com.ecomm.api.backend.hateoas.AddressRepresentation;
import com.ecomm.api.backend.hateoas.CardRepresentation;
import com.ecomm.api.backend.hateoas.UserRepresentation;
import com.ecomm.api.backend.service.UserService;
import com.ecommerce.api.CustomerApi;
import com.ecommerce.api.model.Address;
import com.ecommerce.api.model.Card;
import com.ecommerce.api.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.*;


@RestController
public class CustomerController implements CustomerApi {

    private final AddressRepresentation addressRepresentationAssembler;
    private final CardRepresentation cardRepresentationAssembler;
    private UserService userService;
    private final UserRepresentation userRepresentationAssembler;


    public CustomerController(AddressRepresentation addressRepresentationAssembler, CardRepresentation cardRepresentationAssembler, UserService userService, UserRepresentation userRepresentationAssembler) {
        this.addressRepresentationAssembler = addressRepresentationAssembler;
        this.cardRepresentationAssembler = cardRepresentationAssembler;
        this.userService = userService;
        this.userRepresentationAssembler = userRepresentationAssembler;
    }

    @Override
    public ResponseEntity<Void> deleteCustomerById(String id) {
        userService.deleteCustomerById(id);
        return accepted().build();
    }

    @Override
    public ResponseEntity<List<User>> getAllCustomers() {
        return ok(userRepresentationAssembler.toListModel(userService.getAllCustomers()));
    }

    @Override
    public ResponseEntity<Card> getCardByCustomerId(String id) {
        return userService.getCardByCustomerId(id)
                .map(cardRepresentationAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(notFound().build());
    }


    @Override
    public ResponseEntity<List<Address>> getCustomerAddressByID(String id) {
        return userService.getAddressesByCustomerID(id)
                .map(addressRepresentationAssembler::toListModel)
                .map(ResponseEntity::ok)
                .orElse(notFound().build());
    }

    @Override
    public ResponseEntity<User> getCustomerByID(String id) {
        return null; //userService.getCustomerById(id).map(userRepresentationAssembler::toModel).map(ResponseEntity::ok)
        //.orElse(notFound().build());
    }
}
