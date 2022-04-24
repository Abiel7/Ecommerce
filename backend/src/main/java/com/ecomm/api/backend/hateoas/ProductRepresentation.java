package com.ecomm.api.backend.hateoas;

import com.ecomm.api.backend.controller.ProductController;
import com.ecomm.api.backend.entity.ProductEntity;
import com.ecommerce.api.model.Product;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class ProductRepresentation extends RepresentationModelAssemblerSupport<ProductEntity, Product> {


    public ProductRepresentation() {
        super(ProductController.class, Product.class);
    }

    @Override
    public Product toModel(ProductEntity entity) {
        return null;
    }
}
