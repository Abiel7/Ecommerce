package com.ecomm.api.backend.hateoas;

import com.ecomm.api.backend.controller.CardController;
import com.ecomm.api.backend.entity.CardEntity;
import com.ecommerce.api.model.Card;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CardRepresentation extends RepresentationModelAssemblerSupport<CardEntity, Card> {



    public CardRepresentation(){
        super(CardController.class, Card.class);
    }
    @Override
    public Card toModel(CardEntity entity) {
        String uuid= Objects.nonNull(entity.getUser()) ? entity.getUser().getId().toString() : null;
        Card resource = createModelWithId(entity.getId(), entity);
        System.out.println(resource.toString());
        BeanUtils.copyProperties(entity, resource);
        resource.id(entity.getId().toString())
                .cardnumber(entity.getNumber())
                .ccv(entity.getCvv())
                .expires(entity.getExpires())
                .userId(uuid);


         resource.add(linkTo(methodOn(CardController.class).getCardById(entity.getId().toString())).withSelfRel());
        return resource;
    }

    public List<Card> toListModel(Iterable<CardEntity> entities) {

        if(Objects.isNull(entities)){
            return Collections.emptyList();
        }
        return StreamSupport.stream(entities.spliterator(), false)
                .map(this::toModel)
                .collect(toList());
    }

}
