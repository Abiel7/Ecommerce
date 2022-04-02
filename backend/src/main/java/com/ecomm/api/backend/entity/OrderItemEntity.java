package com.ecomm.api.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class OrderItemEntity {
    @Id
    @GeneratedValue
    @Column(name = "ID",updatable = false,nullable = false)
    private UUID id;
    @Column(name = "ORDER_ID")
    private UUID orderId;
    @Column(name = "ITEM_ID")
    private UUID itemId;

    public UUID getId() {
        return id;
    }
    public OrderItemEntity setId(UUID id) {
        this.id = id;
        return this;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public OrderItemEntity setOrderId(UUID orderId) {
        this.orderId = orderId;
        return this;
    }

    public UUID getItemId() {
        return itemId;
    }

    public OrderItemEntity setItemId(UUID itemId) {
        this.itemId = itemId;
        return this;
    }


}
