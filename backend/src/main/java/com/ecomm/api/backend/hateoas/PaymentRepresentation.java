package com.ecomm.api.backend.hateoas;

import com.ecomm.api.backend.controller.PaymentController;
import com.ecomm.api.backend.entity.PaymentEntity;
import com.ecommerce.api.model.Payment;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class PaymentRepresentation extends RepresentationModelAssemblerSupport<PaymentEntity, Payment> {


    public PaymentRepresentation() {
        super(PaymentController.class, Payment.class);
    }

    @Override
    public Payment toModel(PaymentEntity entity) {
        Payment resource = createModelWithId(entity.getId(),entity);
        BeanUtils.copyProperties(entity,resource);

        return null ;
    }


}
