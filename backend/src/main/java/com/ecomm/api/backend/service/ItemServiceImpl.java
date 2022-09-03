package com.ecomm.api.backend.service;

import com.ecomm.api.backend.entity.reactiveEntity.CartEntity;
import com.ecomm.api.backend.entity.reactiveEntity.ItemEntity;
import com.ecommerce.api.model.Item;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @service works between controller and repository
 * repository's should only be use for retrieval
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Override
    public Mono<ItemEntity> toEntity(Mono<Item> item) {
        return null;
    }

    @Override
    public Mono<List<Item>> fluxToList(Flux<ItemEntity> items) {
        return null;
    }

    @Override
    public Flux<Item> toItemFlux(Mono<CartEntity> items) {
        return null;
    }

    @Override
    public ItemEntity toEntity(Item m) {
        return null;
    }

    @Override
    public List<ItemEntity> toEntityList(List<Item> items) {
        return null;
    }

    @Override
    public Item toModel(ItemEntity e) {
        return null;
    }

    @Override
    public List<Item> toModelList(List<ItemEntity> items) {
        return null;
    }

    @Override
    public Flux<Item> toModelFlux(List<ItemEntity> items) {
        return null;
    }
    /*
     * @param itemEntity
     * @return ItemEntity
     * Add items with id price and quantity
     */
    /*
    @Override
    public ItemEntity toEntity(Item item) {
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setProduct(new ProductEntity().setId(UUID.fromString(item.getItemId())))
                .setPrice(item.getUnitPrice()).setQuantity(item.getQuantity());
        return itemEntity;
    }


    @Override
    public List<ItemEntity> toEntityList(List<Item> items) {
       if(Objects.isNull(items)){
           return Collections.emptyList();
       }

       return items.stream().map(this::toEntity).collect((toList()));
    }

    @Override
    public Item toModel(ItemEntity itemEntity) {
        Item item = new Item();
        item.itemId(itemEntity.getProduct().getId().toString()).unitPrice(itemEntity.getPrice()).quantity(itemEntity.getQuantity());
        return null;
    }

    @Override
    public List<Item> toModelList(List<ItemEntity> items) {
        if(Objects.isNull(items)){
            return Collections.emptyList();
        }
        return items.stream().map(this::toModel).collect(toList());
    }

     */
}


