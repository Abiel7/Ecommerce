package com.ecomm.api.backend.hateoas;

import com.ecomm.api.backend.controller.CardController;
import com.ecomm.api.backend.entity.CardEntity;
import com.ecommerce.api.model.Card;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class CardRepresentation extends RepresentationModelAssemblerSupport<CardEntity, Card> {



    public CardRepresentation(){
        super(CardController.class, Card.class);
    }
    @Override
    public Card toModel(CardEntity entity) {
        return null;
    }
}
