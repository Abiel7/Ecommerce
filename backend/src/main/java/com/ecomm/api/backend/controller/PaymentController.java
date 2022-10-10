package com.ecomm.api.backend.controller;

import com.ecomm.api.backend.hateoas.PaymentRepresentation;
import com.ecomm.api.backend.service.PaymentService;
import com.ecommerce.api.PaymentApi;
import com.ecommerce.api.model.Authorization;
import com.ecommerce.api.model.PaymentReq;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController implements PaymentApi {
    private PaymentService paymentService;
    private final PaymentRepresentation paymentRepresentation;

    public  PaymentController(PaymentService paymentService, PaymentRepresentation paymentRepresentation) {
        this.paymentService = paymentService;
        this.paymentRepresentation = paymentRepresentation;
    }



}
