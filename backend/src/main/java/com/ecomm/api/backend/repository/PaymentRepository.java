package com.ecomm.api.backend.repository;

import com.ecomm.api.backend.entity.PaymentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PaymentRepository extends CrudRepository<PaymentEntity, UUID> {
}
