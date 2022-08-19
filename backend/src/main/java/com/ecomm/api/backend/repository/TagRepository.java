package com.ecomm.api.backend.repository;

import com.ecomm.api.backend.entity.AfterReactiv.TagEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface TagRepository extends ReactiveCrudRepository<TagEntity, UUID> {
    @Query("SELECT t.* from ecomm.product p, ecomm.product_tag pt, ecomm.tag t where p.id = :id  and pt.id = pt.product_id and t.id = pt.tag_id")
    Flux<TagEntity> findTagByproductId(String id);
}
