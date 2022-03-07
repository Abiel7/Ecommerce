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
import org.openapitools.client.model.AddCardReq;
import org.openapitools.client.model.Address;
import org.openapitools.client.model.Card;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for CardApi
 */
@Ignore
public class CardApiTest {

    private final CardApi api = new CardApi();

    
    /**
     * Deletes card&#39;s address
     *
     * Deletes card&#39;s address based on given card ID.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteCardByIdTest() throws ApiException {
        String id = null;
        api.deleteCardById(id);

        // TODO: test validations
    }
    
    /**
     * Returns all user&#39;s cards
     *
     * Returns all user&#39;s cards, else empty collection
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getAllCardsTest() throws ApiException {
        List<Card> response = api.getAllCards();

        // TODO: test validations
    }
    
    /**
     * Returns user&#39;s card
     *
     * Returns user&#39;s card based on given card ID.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getCardByIdTest() throws ApiException {
        String id = null;
        Card response = api.getCardById(id);

        // TODO: test validations
    }
    
    /**
     * Creates a new user addresses
     *
     * Creates a new user addresses. Does nothing if address already exists.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void registerCardTest() throws ApiException {
        AddCardReq addCardReq = null;
        Address response = api.registerCard(addCardReq);

        // TODO: test validations
    }
    
}