package com.ecomm.api.backend.service;

import com.ecomm.api.backend.entity.AfterReactiv.AuthorizationEntity;
import com.ecommerce.api.model.PaymentReq;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface PaymentService {


    Mono<AuthorizationEntity> authorize(@Valid Mono<PaymentReq> paymentReq);
    Mono<AuthorizationEntity> getOrdersPaymentAuthorization(@NotNull String orderId);
}
