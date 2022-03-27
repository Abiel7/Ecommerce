package com.ecomm.api.backend.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "user")
@Data
public class UserEntity {

    @Id
    @GeneratedValue
    @Column(name = "ID",updatable = false,nullable = false)
    private UUID id;

    @NotNull(message = "User name is requaired")
    @Basic(optional = false)
    @Column(name = "USERNAME")
    private String userName;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "USER_STATUS")
    private String userStatus;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinTable (
            name = "USER_ADDRESS",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ADDRES_ID")
    )
    private List<AddressEntity> addressEntities = Collections.emptyList();

    //  FetchType is marked with lazy that means the users  CardEntity, CartEntity
    //  OrderEntity wil be loaded only when asked
    // when entity is not referenced  by the user, by using orphanRemoval = true
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<CardEntity> cards;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true)
    private CartEntity cart;

    @OneToMany(mappedBy = "userEntity", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<OrderEntity> orders;





}
