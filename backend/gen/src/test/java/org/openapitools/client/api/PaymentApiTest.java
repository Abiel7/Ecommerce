/*
 * Ecommerce App
 * api for ecommerce web applications
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: abielkidane16@gmail.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.api;

import org.openapitools.client.ApiException;
import org.openapitools.client.model.Authorization;
import org.openapitools.client.model.PaymentReq;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for PaymentApi
 */
@Ignore
public class PaymentApiTest {

    private final PaymentApi api = new PaymentApi();

    
    /**
     * Authorize a payment request
     *
     * Authorize a payment request.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void authorizeTest() throws ApiException {
        PaymentReq paymentReq = null;
        Authorization response = api.authorize(paymentReq);

        // TODO: test validations
    }
    
    /**
     * Returns the payment authorization
     *
     * Return the payment authorization for the specified order
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getOrdersPaymentAuthorizationTest() throws ApiException {
        String id = null;
        List<Authorization> response = api.getOrdersPaymentAuthorization(id);

        // TODO: test validations
    }
    
}
