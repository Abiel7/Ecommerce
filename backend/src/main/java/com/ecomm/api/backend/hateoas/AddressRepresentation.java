package com.ecomm.api.backend.hateoas;

import com.ecomm.api.backend.controller.AddressController;
import com.ecomm.api.backend.entity.AddressEntity;
import com.ecommerce.api.model.Address;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class AddressRepresentation extends RepresentationModelAssemblerSupport<AddressEntity, Address> {
    /**
     * Creates a new {@link RepresentationModelAssemblerSupport} using the given controller class and resource type.
     *
     *
     */
    public AddressRepresentation() {
        super(AddressController.class, Address.class);
    }

    @Override
    public Address toModel(AddressEntity entity) {
        Address resource =  createModelWithId(entity.getId(), entity);
        BeanUtils.copyProperties(entity, resource);
        resource.setId(entity.getId().toString());
        resource.add(linkTo(methodOn(AddressController.class).getAddressById(entity.getId().toString())).withSelfRel());

        return resource;
    }

    public List<Address> toListModel(Iterable<AddressEntity> entities) {
        if(Objects.isNull(entities)) {
            return Collections.emptyList();
        }
        return StreamSupport.stream(entities.spliterator(), false)
                .map(e -> toModel(e))
                .collect(toList());
    }
}
