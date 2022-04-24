package com.ecomm.api.backend.service;

import com.ecommerce.api.model.Authorization;
import com.ecommerce.api.model.PaymentReq;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public Optional<Authorization> authorize(PaymentReq paymentReq) {
        return Optional.empty();
    }

    @Override
    public Optional<Authorization> getOrderPaymentAuthorization(String orderId) {
        return Optional.empty();
    }
}
