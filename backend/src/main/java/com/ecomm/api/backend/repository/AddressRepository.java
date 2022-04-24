package com.ecomm.api.backend.repository;

import com.ecomm.api.backend.entity.AddressEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


public interface AddressRepository extends CrudRepository<AddressEntity, UUID> {
}
