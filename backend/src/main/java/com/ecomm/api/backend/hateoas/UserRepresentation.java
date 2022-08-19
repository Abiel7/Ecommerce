package com.ecomm.api.backend.hateoas;

import com.ecomm.api.backend.controller.CustomerController;
import com.ecomm.api.backend.entity.AfterReactiv.UserEntity;
import com.ecommerce.api.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserRepresentation extends RepresentationModelAssemblerSupport<UserEntity, User> {
    /**
     * Creates a new {@link RepresentationModelAssemblerSupport} using the given controller class and resource type.
     *

     */
    public UserRepresentation() {
        super(CustomerController.class , User.class);
    }

    @Override
    public User toModel(UserEntity entity) {
        User resource = createModelWithId(entity.getId(), entity);
        BeanUtils.copyProperties(entity, resource);
        resource.id(entity.getId().toString());

        if(entity != null) {
            if(entity.getAddresses().size() > 0 ){
                resource.setAddressId(entity.getAddresses().get(0).getId().toString());
            }
            if(entity.getCard() != null  && entity.getCard().size() > 0 ){
                resource.setCardId(entity.getCard().get(0).getId().toString());
            }
        }
        resource.add(linkTo(methodOn(CustomerController.class)
                    .getCustomerByID(entity.getId().toString())).withSelfRel());
        resource.add(linkTo(methodOn(CustomerController.class)
                .getAllCustomers()).withRel("all-customers"));
        resource.add(linkTo(methodOn(CustomerController.class)
                .getCustomerAddressByID(entity.getId().toString())).withRel("self_address"));
        return resource;
    }

    public List<User> toListModel(Iterable<UserEntity> entities) {
        if(Objects.isNull(entities)) {
            return Collections.emptyList(); //return empty list if null
        }

        return StreamSupport.stream(entities.spliterator(), false)
                .map(this::toModel)
                .collect(toList()); //convert to list and return it

    }
}
