package com.ecomm.api.backend.controller;

import com.ecomm.api.backend.hateoas.PaymentRepresentation;
import com.ecomm.api.backend.service.PaymentService;
import com.ecommerce.api.PaymentApi;
import com.ecommerce.api.model.Authorization;
import com.ecommerce.api.model.PaymentReq;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestController
public class PaymentController implements PaymentApi {
    private PaymentService paymentService;
    private final PaymentRepresentation paymentRepresentation;

    public PaymentController(PaymentService paymentService, PaymentRepresentation paymentRepresentation) {
        this.paymentService = paymentService;
        this.paymentRepresentation = paymentRepresentation;
    }


    @Override
    public Mono<ResponseEntity<Authorization>> getOrderPaymentAuthorization(String id, ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<ResponseEntity<Authorization>> authorize(Mono<PaymentReq> paymentReq, ServerWebExchange exchange) {
        return null;
    }
}
