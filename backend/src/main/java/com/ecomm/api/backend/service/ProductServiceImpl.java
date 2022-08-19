package com.ecomm.api.backend.service;

import com.ecomm.api.backend.entity.AfterReactiv.ProductEntity;
import com.ecomm.api.backend.entity.AfterReactiv.TagEntity;
import com.ecomm.api.backend.repository.ProductRepository;
import com.ecomm.api.backend.repository.TagRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.function.BiFunction;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private TagRepository tagRepository;
    private BiFunction <ProductEntity, List<TagEntity>, ProductEntity> productEntityBiFunction = (productEntity, tags) -> productEntity.setTags(tags);





    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.tagRepository = tagRepository;
    }

    @Override
    public Flux<ProductEntity> getAllProducts() {
        return productRepository.findAll()
                .flatMap(products -> Mono.just(products)
                        .zipWith(tagRepository.findTagByproductId(products.getId().toString()).collectList())
                        .map(t -> t.getT1().setTags(t.getT2())));
    }

    @Override
    public Mono<ProductEntity> getProduct(String id) {
        // schedulers boundedElastic is used to offload blocking tasks
        Mono<ProductEntity> products =  productRepository.findById(UUID.fromString(id)).subscribeOn(Schedulers.boundedElastic());
        Flux<TagEntity> tags = tagRepository.findTagByproductId(id).subscribeOn(Schedulers.boundedElastic());
        return Mono.zip(products,tags.collectList(),productEntityBiFunction);
    }


    /*
    before reactive approach
    @Override
    public Iterable<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<ProductEntity> getProduct(String id) {
        return productRepository.findById(UUID.fromString(id));
    }

     */
}
