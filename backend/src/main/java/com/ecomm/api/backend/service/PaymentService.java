package com.ecomm.api.backend.service;

import com.ecommerce.api.model.Authorization;
import com.ecommerce.api.model.PaymentReq;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public interface PaymentService {

    Optional<Authorization> authorize(@Valid  PaymentReq paymentReq);

    Optional<Authorization> getOrderPaymentAuthorization (@NotNull  String orderId);
}
