package com.ecomm.api.backend.entity;


import lombok.Data;

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
    @Column(name = "ID", updatable = false,nullable = false)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "User_ID", referencedColumnName = "ID")
    private UserEntity users ;

    @ManyToMany(cascade= CascadeType.ALL)
    @JoinTable(
            name = "CART_ITEM",
            joinColumns = @JoinColumn(name = "CART_ID"),
            inverseJoinColumns = @JoinColumn(name = "ITEM_ID")

    )
    private List<ItemEntity> items = Collections.emptyList();

    public UUID getId() {
        return id;
    }

    public CartEntity setId(UUID id) {
        this.id = id;
        return this;
    }
    public UserEntity getUsers() {
        return users;
    }

    public CartEntity setUsers(UserEntity users) {
        this.users = users;
        return this;
    }
    public List<ItemEntity> getItems() {
        return items;
    }

    public CartEntity setItems(List<ItemEntity> items) {
        this.items = items;
        return this;
    }
    @Override
    public int hashCode() {
        return Objects.hash(users,items);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final CartEntity other = (CartEntity) obj;
        return users.equals(other.users) && Objects.equals(id, other.id);
    }
    @Override
    public String toString() {
        return "CartEntity{" +
                "id=" + id +
                ", users=" + users +
                ", items=" + items +
                '}';
    }




}
