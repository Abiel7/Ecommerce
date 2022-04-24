package com.ecomm.api.backend.hateoas;

import com.ecomm.api.backend.controller.ShipmentController;
import com.ecomm.api.backend.entity.ShipmentEntity;
import com.ecommerce.api.model.Shipment;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class ShipmentRepresentation  extends RepresentationModelAssemblerSupport<ShipmentEntity, Shipment> {


    /**
     * Creates a new {@link RepresentationModelAssemblerSupport} using the given controller class and resource type.
     *

     */
    public ShipmentRepresentation() {
        super(ShipmentController.class,Shipment.class);
    }

    @Override
    public Shipment toModel(ShipmentEntity entity) {
        return null;
    }
}
