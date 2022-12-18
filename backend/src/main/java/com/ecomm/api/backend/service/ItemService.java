package com.ecomm.api.backend.service;

import com.ecomm.api.backend.entity.ItemEntity;
import com.ecommerce.api.model.Item;

import java.util.List;

public interface ItemService {
    ItemEntity toEntity(Item item);

    List<ItemEntity>  toEntityList(List<Item> items);

    Item toModel(ItemEntity itemEntity);

    List<Item> toModelList(List<ItemEntity> items );
}
