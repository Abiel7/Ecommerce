package com.ecomm.api.backend.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "shipment")
public class ShipmentEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false,columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "EST_DELIVERY_DATE")
    private Timestamp estDeliveryDate;

    @Column(name = "CARRIER")
    private String carrier;

    public UUID getId() {
        return id;
    }

    public ShipmentEntity setId(UUID id) {
        this.id = id;
        return this;
    }

    public Timestamp getEstDeliveryDate() {
        return estDeliveryDate;
    }

    public ShipmentEntity setEstDeliveryDate(Timestamp estDeliveryDate) {
        this.estDeliveryDate = estDeliveryDate;
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