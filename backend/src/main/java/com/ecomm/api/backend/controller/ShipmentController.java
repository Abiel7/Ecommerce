package com.ecomm.api.backend.controller;

import com.ecomm.api.backend.hateoas.ShipmentRepresentation;
import com.ecomm.api.backend.service.ShipmentService;
import com.ecommerce.api.ShippingApi;
import com.ecommerce.api.model.Authorization;
import com.ecommerce.api.model.Shipment;
import com.ecommerce.api.model.ShippingReq;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShipmentController implements ShippingApi {

    private ShipmentService shipmentService;
    private final ShipmentRepresentation shipmentRepresentationAssembly;

    public ShipmentController (ShipmentService shipmentService, ShipmentRepresentation shipmentRepresentationAssembly) {
        this.shipmentService = shipmentService;
        this.shipmentRepresentationAssembly = shipmentRepresentationAssembly;
    }

    @Override
    public ResponseEntity<List<Shipment>> getShippingByOrderid(String id) {
        return ResponseEntity.ok(shipmentRepresentationAssembly.toListModel(shipmentService.getShipmentByOrderId(id)));
    }

    @Override
    public ResponseEntity<Authorization> shipOrder(ShippingReq shippingReq) {
        return null; // TODO
    }
}
