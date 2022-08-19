package com.ecomm.api.backend.repository;

import com.ecomm.api.backend.entity.AfterReactiv.PaymentEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;


public interface PaymentRepository extends ReactiveCrudRepository<PaymentEntity, UUID> {
}
