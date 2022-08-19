package com.ecomm.api.backend.service;

import com.ecomm.api.backend.entity.AfterReactiv.AuthorizationEntity;
import com.ecomm.api.backend.repository.OrderRepository;
import com.ecomm.api.backend.repository.PaymentRepository;
import com.ecommerce.api.model.PaymentReq;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Service
public class PaymentServiceImpl implements PaymentService {

    private PaymentRepository paymentRepository;
    private OrderRepository orderRepository;
    public PaymentServiceImpl(PaymentRepository paymentRepository, OrderRepository orderRepository) {
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
    }
    @Override
    public Mono<AuthorizationEntity> authorize(@Valid Mono<PaymentReq> paymentReq) {
        return Mono.empty();
    }

    @Override
    public Mono<AuthorizationEntity> getOrdersPaymentAuthorization(String orderId) {
        return null;
    }
}
