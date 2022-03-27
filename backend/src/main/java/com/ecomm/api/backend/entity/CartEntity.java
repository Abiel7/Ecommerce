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
    private UserEntity user;

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
    public UserEntity getUser() {
        return user;
    }

    public CartEntity setUser(UserEntity users) {
        this.user = users;
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
        return Objects.hash(user,items);
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
        return user.equals(other.user) && Objects.equals(id, other.id);
    }
    @Override
    public String toString() {
        return "CartEntity{" +
                "id=" + id +
                ", users=" + user +
                ", items=" + items +
                '}';
    }




}
