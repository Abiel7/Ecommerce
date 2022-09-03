package com.ecomm.api.backend.service;

import com.ecomm.api.backend.entity.reactiveEntity.CardEntity;
import com.ecommerce.api.model.AddCardReq;
import com.ecommerce.api.model.Card;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.UUID;

public interface CardService {
     Mono<Void> deleteCardById(String id);
     Mono<Void> delteCardByID(UUID id );
     Flux<Card> getAllCards();
     Mono<CardEntity> getCardById(String id);
     Mono<CardEntity> registerCard(@Valid Mono<AddCardReq> addCardReq);

     CardEntity toEntity(AddCardReq  model);

    /*
    Before reactive streams
     Iterable<CardEntity>  getAllCards();
    Optional<CardEntity> getCardById(String id);
    Optional<CardEntity> registerCard(@Valid AddCardReq addCardReq);
    void deleteCardById(String id);
     */

}
