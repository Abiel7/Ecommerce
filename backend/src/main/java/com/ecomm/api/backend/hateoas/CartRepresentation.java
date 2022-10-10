package com.ecomm.api.backend.hateoas;

import com.ecomm.api.backend.controller.CartsController;
import com.ecomm.api.backend.entity.CartEntity;
import com.ecomm.api.backend.service.ItemService;
import com.ecommerce.api.model.Card;
import com.ecommerce.api.model.Cart;
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

//  convert domain objects into representation model
@Component
public class CartRepresentation extends RepresentationModelAssemblerSupport<CartEntity, Cart> {


private ItemService itemService;
    public CartRepresentation(ItemService itemService){
        super(CartsController.class,Cart.class);
        this.itemService = itemService;
    }
    @Override
    public Cart toModel(CartEntity entity) {
        String uid = Objects.nonNull(entity.getUser()) ? entity.getUser().getId().toString() :  null;
        System.out.println( uid);
        String cid = Objects.nonNull(entity.getId()) ? entity.getId().toString() : null;

        Cart resource = new  Cart();

        BeanUtils.copyProperties(entity,resource);
        resource.customerId(cid).customerId(uid)
                .items(itemService.toModelList(entity.getItems()));
        resource.add(linkTo(methodOn(CartsController.class).getCartByCustomerId(uid)).withSelfRel());
        resource.add(linkTo(methodOn(CartsController.class).getCartItemsByCustomerId(uid.toString())).withRel("cart-items"));
        return resource;
    }

    public List<Cart> toListModel(Iterable<CartEntity> entities) {
        if(Objects.isNull(entities)) {
            return Collections.emptyList();
        }

        return StreamSupport.stream(entities.spliterator(),false)
                .map(e -> toModel(e))
                .collect(toList());
    }
}

