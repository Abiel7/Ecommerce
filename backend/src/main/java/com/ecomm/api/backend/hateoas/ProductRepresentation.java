package com.ecomm.api.backend.hateoas;
import com.ecomm.api.backend.controller.ProductController;
import com.ecomm.api.backend.entity.ProductEntity;
import com.ecommerce.api.model.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProductRepresentation extends RepresentationModelAssemblerSupport<ProductEntity, Product> {


    public ProductRepresentation() {
        super(ProductController.class, Product.class);
    }

    @Override
    public Product toModel(ProductEntity entity) {
        Product resource = createModelWithId(entity.getId(), entity);
        BeanUtils.copyProperties(entity, resource);
        resource.setId(entity.getId().toString());
        //resource.setTag(entity.getTags().stream().map(t -> new Tag().id(t.getId().toString()).name(t.getName())).collect(toList()));

        resource.add(linkTo(methodOn(ProductController.class).getProduct(entity.getId().toString())).withSelfRel());
        //resource.add(linkTo(methodOn(ProductController.class).queryProducts(null, null,1,10)).withRel("products"));
        return null;
    }

    public List<Product> toListModel(Iterable<ProductEntity> entities) {
        if(Objects.isNull(entities)) {
            return Collections.emptyList();
        }
        return StreamSupport.stream(entities.spliterator(), false)
                .map(p -> toModel(p))
                .collect(toList());
    }
}
