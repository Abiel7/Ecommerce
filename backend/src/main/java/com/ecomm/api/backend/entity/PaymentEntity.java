package com.ecomm.api.backend.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "payment")
public class PaymentEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false,columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name="AUTHORIZED")
    private boolean authorized;

    @Column(name = "MESSAGE")
    private String message;

    @OneToOne(mappedBy = "paymentEntity")
    private OrderEntity orderEntity;

    public UUID getId() {
        return id;
    }

    public PaymentEntity setId(UUID id) {
        this.id = id;
        return this;
    }

    public boolean isAuthorized() {
        return authorized;
    }

    public PaymentEntity setAuthorized(boolean authorized) {
        this.authorized = authorized;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public PaymentEntity setMessage(String message) {
        this.message = message;
        return this;
    }
}