package com.ecomm.api.backend.entity;


import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "cart")
public class CartEntity {
    @Id
    @GeneratedValue
    @Column(name = "cart_id", updatable = false,nullable = false)
    private UUID cartId;

    @OneToOne
    @JoinColumn(name = "User_ID", referencedColumnName = "ID")
    private UserEntity userEntity;

    @ManyToMany(cascade= CascadeType.ALL)
    @JoinTable(
            name = "CART_ITEM",
            joinColumns = @JoinColumn(name = "CART_ID"),
            inverseJoinColumns = @JoinColumn(name = "ITEM_ID")

    )
    private List<ItemEntity> items = Collections.emptyList();
}
