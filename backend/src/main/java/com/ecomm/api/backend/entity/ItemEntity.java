package com.ecomm.api.backend.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "item")
public class ItemEntity {

    @Id
    @GeneratedValue
    @Column(name ="ID", updatable = false,nullable = false)
    private UUID id;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID",referencedColumnName = "ID")
    private ProductEntity product;

    @Column(name = "UNIT_PRICE")
    private BigDecimal price;

    @ManyToMany(mappedBy = "items",fetch = FetchType.LAZY)
    private List<CartEntity> cart;

    @ManyToMany(mappedBy = "items",fetch = FetchType.LAZY)
    private List<OrderEntity> orders;

    public UUID getId() {
        return id;
    }

    public ItemEntity setId(UUID id) {
        this.id = id;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public ItemEntity setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public ItemEntity setProduct(ProductEntity product) {
        this.product = product;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ItemEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public List<CartEntity> getCart() {
        return cart;
    }

    public ItemEntity setCart(List<CartEntity> cart) {
        this.cart = cart;
        return this;
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }

    public ItemEntity setOrders(List<OrderEntity> orders) {
        this.orders = orders;
        return this;
    }


}
