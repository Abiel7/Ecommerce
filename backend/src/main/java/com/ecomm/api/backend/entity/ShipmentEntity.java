package com.ecomm.api.backend.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "shipment")
public class ShipmentEntity {

    @Id
    @GeneratedValue
    @Column(name= "ID", nullable = false, updatable = false)
    private UUID id;
    @Column(name ="ESTIMATED_DELIVERY_DATE")
    private Timestamp estimatedDeliveryDate;
    @Column(name = "CARRIER")
    private String carrier;

    public UUID getId() {
        return id;
    }

    public ShipmentEntity setId(UUID id) {
        this.id = id;
        return this;
    }

    public Timestamp getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public ShipmentEntity setEstimatedDeliveryDate(Timestamp estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
        return this;
    }

    public String getCarrier() {
        return carrier;
    }

    public ShipmentEntity setCarrier(String carrier) {
        this.carrier = carrier;
        return this;
    }


}
