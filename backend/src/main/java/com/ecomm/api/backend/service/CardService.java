package com.ecomm.api.backend.service;

import com.ecomm.api.backend.entity.CardEntity;
import com.ecommerce.api.model.AddCardReq;
import com.ecommerce.api.model.Card;

import javax.validation.Valid;
import java.util.Optional;

public interface CardService {
     Iterable<CardEntity>  getAllCards();
    Optional<CardEntity> getCardById(String id);
    Optional<CardEntity> registerCard(@Valid AddCardReq addCardReq);
    void deleteCardById(String id);

}
