package com.ecomm.api.backend.controller;

import com.ecomm.api.backend.hateoas.CardRepresentation;
import com.ecomm.api.backend.service.CardService;
import com.ecomm.api.backend.service.CartService;
import com.ecommerce.api.CardApi;
import com.ecommerce.api.model.AddCardReq;
import com.ecommerce.api.model.Card;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.*;

@RestController
public class CardController implements CardApi {

    private CardService cardService;
    private final CardRepresentation cardRepresentationAssembler;

    public CardController(CardService cartService, CardRepresentation cardRepresentationAssembler) {
        this.cardService = cartService;
        this.cardRepresentationAssembler = cardRepresentationAssembler;
    }
    @Override
    public ResponseEntity<Void> deleteCardByID(String id) {
        cardService.deleteCardById(id);
        return accepted().build();
    }

    @Override
    public ResponseEntity<Card> getCardById(String id) {
        return cardService.getCardById(id)
                .map(cardRepresentationAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(notFound().build());
    }
    @Override
    public ResponseEntity<List<Card>> getAllCards() {
        return ok(cardRepresentationAssembler.toListModel(cardService.getAllCards()));//CardApi.super.getCards();
    }

    @Override
    public ResponseEntity<Card> registerCard(AddCardReq addCardReq) {
        return  status(HttpStatus.CREATED).body(cardService.registerCard(addCardReq)
                .map(cardRepresentationAssembler::toModel).get());



    }
}
