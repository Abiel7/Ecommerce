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

import org.openapitools.client.ApiCallback;
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.ApiResponse;
import org.openapitools.client.Configuration;
import org.openapitools.client.Pair;
import org.openapitools.client.ProgressRequestBody;
import org.openapitools.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import org.openapitools.client.model.NewOrder;
import org.openapitools.client.model.Order;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderApi {
    private ApiClient localVarApiClient;

    public OrderApi() {
        this(Configuration.getDefaultApiClient());
    }

    public OrderApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for addOrder
     * @param newOrder New Order Request object (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Order added successfully </td><td>  -  </td></tr>
        <tr><td> 406 </td><td> If payment is not authorized. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call addOrderCall(NewOrder newOrder, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = newOrder;

        // create path and map variables
        String localVarPath = "/api/v1/orders";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call addOrderValidateBeforeCall(NewOrder newOrder, final ApiCallback _callback) throws ApiException {
        

        okhttp3.Call localVarCall = addOrderCall(newOrder, _callback);
        return localVarCall;

    }

    /**
     * Creates a new order for the given order request
     * Creates a new order for the given order request.
     * @param newOrder New Order Request object (optional)
     * @return List&lt;Order&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Order added successfully </td><td>  -  </td></tr>
        <tr><td> 406 </td><td> If payment is not authorized. </td><td>  -  </td></tr>
     </table>
     */
    public List<Order> addOrder(NewOrder newOrder) throws ApiException {
        ApiResponse<List<Order>> localVarResp = addOrderWithHttpInfo(newOrder);
        return localVarResp.getData();
    }

    /**
     * Creates a new order for the given order request
     * Creates a new order for the given order request.
     * @param newOrder New Order Request object (optional)
     * @return ApiResponse&lt;List&lt;Order&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Order added successfully </td><td>  -  </td></tr>
        <tr><td> 406 </td><td> If payment is not authorized. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<List<Order>> addOrderWithHttpInfo(NewOrder newOrder) throws ApiException {
        okhttp3.Call localVarCall = addOrderValidateBeforeCall(newOrder, null);
        Type localVarReturnType = new TypeToken<List<Order>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Creates a new order for the given order request (asynchronously)
     * Creates a new order for the given order request.
     * @param newOrder New Order Request object (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Order added successfully </td><td>  -  </td></tr>
        <tr><td> 406 </td><td> If payment is not authorized. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call addOrderAsync(NewOrder newOrder, final ApiCallback<List<Order>> _callback) throws ApiException {

        okhttp3.Call localVarCall = addOrderValidateBeforeCall(newOrder, _callback);
        Type localVarReturnType = new TypeToken<List<Order>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getOrdersByCustomerId
     * @param customerId Customer Identifier (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> If order exists. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Order doesn&#39;t exist for given user. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getOrdersByCustomerIdCall(String customerId, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/v1/orders";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (customerId != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("customerId", customerId));
        }

        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getOrdersByCustomerIdValidateBeforeCall(String customerId, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'customerId' is set
        if (customerId == null) {
            throw new ApiException("Missing the required parameter 'customerId' when calling getOrdersByCustomerId(Async)");
        }
        

        okhttp3.Call localVarCall = getOrdersByCustomerIdCall(customerId, _callback);
        return localVarCall;

    }

    /**
     * Returns the orders of given user
     * Returns orders of given user
     * @param customerId Customer Identifier (required)
     * @return List&lt;Order&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> If order exists. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Order doesn&#39;t exist for given user. </td><td>  -  </td></tr>
     </table>
     */
    public List<Order> getOrdersByCustomerId(String customerId) throws ApiException {
        ApiResponse<List<Order>> localVarResp = getOrdersByCustomerIdWithHttpInfo(customerId);
        return localVarResp.getData();
    }

    /**
     * Returns the orders of given user
     * Returns orders of given user
     * @param customerId Customer Identifier (required)
     * @return ApiResponse&lt;List&lt;Order&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> If order exists. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Order doesn&#39;t exist for given user. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<List<Order>> getOrdersByCustomerIdWithHttpInfo(String customerId) throws ApiException {
        okhttp3.Call localVarCall = getOrdersByCustomerIdValidateBeforeCall(customerId, null);
        Type localVarReturnType = new TypeToken<List<Order>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Returns the orders of given user (asynchronously)
     * Returns orders of given user
     * @param customerId Customer Identifier (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> If order exists. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Order doesn&#39;t exist for given user. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getOrdersByCustomerIdAsync(String customerId, final ApiCallback<List<Order>> _callback) throws ApiException {

        okhttp3.Call localVarCall = getOrdersByCustomerIdValidateBeforeCall(customerId, _callback);
        Type localVarReturnType = new TypeToken<List<Order>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getOrdersByOrderId
     * @param id Order Identifier (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> If order exists. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Order doesn&#39;t exist for given user. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getOrdersByOrderIdCall(String id, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/v1/orders/{id}"
            .replaceAll("\\{" + "id" + "\\}", localVarApiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getOrdersByOrderIdValidateBeforeCall(String id, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling getOrdersByOrderId(Async)");
        }
        

        okhttp3.Call localVarCall = getOrdersByOrderIdCall(id, _callback);
        return localVarCall;

    }

    /**
     * Returns the order of given order ID
     * Returns orders of given order ID
     * @param id Order Identifier (required)
     * @return Order
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> If order exists. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Order doesn&#39;t exist for given user. </td><td>  -  </td></tr>
     </table>
     */
    public Order getOrdersByOrderId(String id) throws ApiException {
        ApiResponse<Order> localVarResp = getOrdersByOrderIdWithHttpInfo(id);
        return localVarResp.getData();
    }

    /**
     * Returns the order of given order ID
     * Returns orders of given order ID
     * @param id Order Identifier (required)
     * @return ApiResponse&lt;Order&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> If order exists. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Order doesn&#39;t exist for given user. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Order> getOrdersByOrderIdWithHttpInfo(String id) throws ApiException {
        okhttp3.Call localVarCall = getOrdersByOrderIdValidateBeforeCall(id, null);
        Type localVarReturnType = new TypeToken<Order>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Returns the order of given order ID (asynchronously)
     * Returns orders of given order ID
     * @param id Order Identifier (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> If order exists. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Order doesn&#39;t exist for given user. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getOrdersByOrderIdAsync(String id, final ApiCallback<Order> _callback) throws ApiException {

        okhttp3.Call localVarCall = getOrdersByOrderIdValidateBeforeCall(id, _callback);
        Type localVarReturnType = new TypeToken<Order>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
