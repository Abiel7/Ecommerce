package com.ecomm.api.backend.service;

import com.ecomm.api.backend.entity.AuthorizationEntity;
import com.ecommerce.api.model.Authorization;
import com.ecommerce.api.model.PaymentReq;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public interface PaymentService {


    Mono<AuthorizationEntity> authorize(@Valid Mono<PaymentReq> paymentReq);
    Mono<AuthorizationEntity> getOrdersPaymentAuthorization(@NotNull String orderId);
}
