package com.ecomm.api.backend.service;

import com.ecomm.api.backend.entity.ProductEntity;
import com.ecommerce.api.model.Product;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Validated
public interface ProductService {
    @NotNull Iterable<ProductEntity> getAllProducts();
    Optional<ProductEntity> getProduct( @Min(value = 1l, message = "Invalid product Id") String id);


}
