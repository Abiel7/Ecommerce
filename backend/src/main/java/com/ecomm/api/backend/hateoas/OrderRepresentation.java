package com.ecomm.api.backend.hateoas;

import com.ecomm.api.backend.controller.OrderController;
import com.ecomm.api.backend.entity.OrderEntity;
import com.ecomm.api.backend.service.ItemService;
import com.ecommerce.api.model.Order;
import com.ecommerce.api.model.Shipment;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import java.time.ZoneOffset;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class OrderRepresentation extends RepresentationModelAssemblerSupport<OrderEntity, Order> {

    private UserRepresentation userRepresentation;
    private AddressRepresentation addressRepresentation;
    private CardRepresentation cardRepresentation;
    private ShipmentRepresentation shipmentRepresentation;
    private ItemService itemService;

    public OrderRepresentation(UserRepresentation userRepresentation,
                               AddressRepresentation addressRepresentation,
                               CardRepresentation cardRepresentation,
                               ShipmentRepresentation shipmentRepresentation,
                               ItemService itemService) {
        super(OrderController.class,Order.class);
        this.userRepresentation = userRepresentation;
        this.addressRepresentation = addressRepresentation;
        this.cardRepresentation = cardRepresentation;
        this.shipmentRepresentation = shipmentRepresentation;
        this.itemService = itemService;
    }

    /**
     * Creates a new {@link RepresentationModelAssemblerSupport} using the given controller class and resource type.
     *
     *
     */


    @Override
    public Order toModel(OrderEntity entity) {
        System.out.println("\n\n\nentity: "+entity);
        Order resource = createModelWithId(entity.getId(), entity);
        BeanUtils.copyProperties(entity, resource);
        resource.id(entity.getId().toString())
                .customer(userRepresentation.toModel(entity.getUserEntity()))
                .address(addressRepresentation.toModel(entity.getAddressEntity()))
                .card(cardRepresentation.toModel(entity.getCardEntity()))
                .items(itemService.toModelList(entity.getItems()))
                .date(entity.getOrderDate().toInstant().atOffset(ZoneOffset.UTC));
        System.out.println("\n\n\nresource: "+resource);

        resource.add(linkTo(methodOn(OrderController.class).getOrderById(entity.getId().toString())).withSelfRel());
        return resource;
    }

}
