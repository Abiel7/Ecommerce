package com.ecomm.api.backend.service;

import com.ecomm.api.backend.entity.reactiveEntity.CartEntity;
import com.ecomm.api.backend.entity.reactiveEntity.ItemEntity;
import com.ecommerce.api.model.Item;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ItemService {

    Mono<ItemEntity> toEntity(Mono<Item> item);

    Mono<List<Item>> fluxToList(Flux<ItemEntity> items );

    Flux<Item> toItemFlux(Mono<CartEntity> items);

    ItemEntity toEntity(Item m);

    List<ItemEntity> toEntityList(List<Item> items);

    Item toModel(ItemEntity e);

    List<Item> toModelList(List<ItemEntity> items);

    Flux<Item> toModelFlux(List<ItemEntity> items);



}
