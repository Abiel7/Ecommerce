package com.ecomm.api.backend.service;

import com.ecomm.api.backend.entity.ItemEntity;
import com.ecomm.api.backend.entity.ProductEntity;
import com.ecommerce.api.model.Item;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * @service works between controller and repository
 * repository's should only be use for retrieval
 */
@Service
public class ItemServiceImpl implements ItemService {

    /*
    * @param itemEntity
    * @return ItemEntity
    * Add items with id price and quantity
     */
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
}


