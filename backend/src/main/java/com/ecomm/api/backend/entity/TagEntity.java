package com.ecomm.api.backend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "tag")
public class TagEntity {
    @Id
    @GeneratedValue
    @Column(name="ID", nullable = false,updatable = false)
    private UUID id;
    @NotNull(message = "Tag name cannot be null")
    @Basic(optional = false)
    @Column(name ="NAME")
    private  String name;

    public UUID getId() {
        return id;
    }

    public TagEntity setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TagEntity setName(String name) {
        this.name = name;
        return this;
    }

}






