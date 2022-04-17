package com.ecomm.api.backend.repository;

import com.ecomm.api.backend.entity.TagEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TagRepository extends CrudRepository<TagEntity, UUID> {
}
