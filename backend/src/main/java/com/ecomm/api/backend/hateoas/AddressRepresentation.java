package com.ecomm.api.backend.hateoas;

import com.ecomm.api.backend.entity.reactiveEntity.AddressEntity;
import com.ecommerce.api.model.Address;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.reactive.ReactiveRepresentationModelAssembler;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import reactor.util.annotation.Nullable;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Component
public class AddressRepresentation implements ReactiveRepresentationModelAssembler<AddressEntity, Address>, HateoasSupport {
    private static String serverURI = null;

    /**
     * Creates a new {@link RepresentationModelAssemblerSupport} using the given controller class and resource type.
     */
    @Override
    public Mono<Address> toModel(AddressEntity entity, ServerWebExchange exchange) {
        return null;
    }

    public Address entityModel(AddressEntity addressEntity, ServerWebExchange exchange) {
        Address resource = new Address();
        if (Objects.isNull(addressEntity)) {
            return resource;
        }
        BeanUtils.copyProperties(addressEntity, resource);
        resource.setId(addressEntity.getId().toString());
        String serverUi = getServerURI(exchange);
        return null;
    }

    public String getServerURI(@Nullable ServerWebExchange exchange) {
        if (Strings.isBlank(serverURI)) {
            serverURI = getUriComponentsBuilder(exchange).toUriString();
        }
        return serverURI;
    }

    public List<Address> toListModel(Iterable<AddressEntity> entities) {
        if (Objects.isNull(entities)) {
            return Collections.emptyList();
        }
        return null; //StreamSupport.stream(entities.spliterator(), false)
        //.map(e -> toModel(e))
        //.collect(toList());
    }
}
