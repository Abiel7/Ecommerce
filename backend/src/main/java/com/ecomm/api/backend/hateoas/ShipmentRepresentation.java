package com.ecomm.api.backend.hateoas;

import com.ecomm.api.backend.controller.ShipmentController;
import com.ecomm.api.backend.entity.AfterReactiv.ShipmentEntity;
import com.ecommerce.api.model.Shipment;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;


import java.util.*;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ShipmentRepresentation  extends RepresentationModelAssemblerSupport<ShipmentEntity, Shipment> {


    /**
     * Creates a new {@link RepresentationModelAssemblerSupport} using the given controller class and resource type.
     */
    public ShipmentRepresentation() {
        super(ShipmentController.class, Shipment.class);
    }

    @Override
    public Shipment toModel(ShipmentEntity entity) {
        Shipment resource = createModelWithId(entity.getId(), entity);
        BeanUtils.copyProperties(entity, resource);
        resource.setOrderid(entity.getId().toString());
        resource.add(linkTo(methodOn(ShipmentController.class).getShippingByOrderid(entity.getId().toString())).withRel("shipment_by_orderId"));
        return null;
    }

    public List<Shipment> toListModel(Iterable<ShipmentEntity> entities) {
        if (Objects.isNull(entities)) {
            return Collections.emptyList();

        }
        return StreamSupport.stream(entities.spliterator(), false).map(this::toModel).collect(toList());
    }
}
