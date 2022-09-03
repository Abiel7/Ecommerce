package com.ecomm.api.backend.controller;

import com.ecomm.api.backend.hateoas.CardRepresentation;
import com.ecomm.api.backend.service.CardService;
import com.ecommerce.api.CardApi;
import com.ecommerce.api.model.AddCardReq;
import com.ecommerce.api.model.Card;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CardController implements CardApi {

    private CardService cardService;
    private final CardRepresentation cardRepresentationAssembler;

    public CardController(CardService cartService, CardRepresentation cardRepresentationAssembler) {
        this.cardService = cartService;
        this.cardRepresentationAssembler = cardRepresentationAssembler;
    }

    @Override
    public Mono<ResponseEntity<Void>> deleteCardByID(String id, ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<ResponseEntity<Flux<Card>>> getAllCards(ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<ResponseEntity<Card>> getCardById(String id, ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<ResponseEntity<Card>> registerCard(Mono<AddCardReq> addCardReq, ServerWebExchange exchange) {
        return null;
    }
}
