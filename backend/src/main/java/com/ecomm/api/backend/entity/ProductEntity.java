package com.ecomm.api.backend.entity;

import com.ecommerce.api.model.Product;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false, updatable = false)
    private UUID id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "PRICE")
    private BigDecimal price;
    @Column(name = "IMAGE_URL")
    private String imageUrl;
    @Column(name ="COUNT")
    private int count;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "PRODUCT_TAG",
            joinColumns = @JoinColumn(name = "PRODUCT_ID"),
            inverseJoinColumns = @JoinColumn(name = "TAG_ID")
    )
    public List<TagEntity> tags = Collections.emptyList();

    @OneToMany(mappedBy = "product")
    private List<ItemEntity> items;

    public ProductEntity() {}

    public ProductEntity(UUID id , @NotNull(message = "product name cannot be null") String name, String description, BigDecimal price, String imageUrl, int count) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        this.count = count;
    }

    public  UUID getId() {
        return id;
    }
    public ProductEntity setId(UUID id) {
        this.id = id;
        return this;
    }
    public String getName() {
        return name;
    }
    public ProductEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }
    public ProductEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public int getCount() {
        return count;
    }

    public ProductEntity setCount(int count) {
        this.count = count;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ProductEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public List<TagEntity> getTags() {
        return tags;
    }

    public ProductEntity setTags(List<TagEntity> tags) {
        this.tags = tags;
        return this;
    }

    public List<ItemEntity> getItems() {
        return items;
    }

    public ProductEntity setItems(List<ItemEntity> items) {
        this.items = items;
        return this;
    }




}
