# CustomerApi

All URIs are relative to *https://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteCustomerById**](CustomerApi.md#deleteCustomerById) | **DELETE** /api/v1/customers/{id} | Deletes the customer
[**getAddressesByCustomerId**](CustomerApi.md#getAddressesByCustomerId) | **GET** /api/v1/customers/{id}/addresses | Returns all customer&#39;s addresses
[**getAllCustomers**](CustomerApi.md#getAllCustomers) | **GET** /api/v1/customers | Returns all customers
[**getCardsByCustomerId**](CustomerApi.md#getCardsByCustomerId) | **GET** /api/v1/customers/{id}/cards | Returns all customer&#39;s cards
[**getCustomerById**](CustomerApi.md#getCustomerById) | **GET** /api/v1/customers/{id} | Returns a customer


<a name="deleteCustomerById"></a>
# **deleteCustomerById**
> deleteCustomerById(id)

Deletes the customer

Deletes the customer identifiable by given ID

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.CustomerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:8080");

    CustomerApi apiInstance = new CustomerApi(defaultClient);
    String id = "id_example"; // String | Customer Identifier
    try {
      apiInstance.deleteCustomerById(id);
    } catch (ApiException e) {
      System.err.println("Exception when calling CustomerApi#deleteCustomerById");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Customer Identifier |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**202** | Request accepted, returns this status even if user does not exist |  -  |

<a name="getAddressesByCustomerId"></a>
# **getAddressesByCustomerId**
> Address getAddressesByCustomerId(id)

Returns all customer&#39;s addresses

Returns all customer&#39;s addresses based on given customer ID

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.CustomerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:8080");

    CustomerApi apiInstance = new CustomerApi(defaultClient);
    String id = "id_example"; // String | Customer Identifier
    try {
      Address result = apiInstance.getAddressesByCustomerId(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CustomerApi#getAddressesByCustomerId");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Customer Identifier |

### Return type

[**Address**](Address.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/xml, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | For successful fetch. |  -  |

<a name="getAllCustomers"></a>
# **getAllCustomers**
> List&lt;User&gt; getAllCustomers()

Returns all customers

Returns all customers, or empty collection if no use found

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.CustomerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:8080");

    CustomerApi apiInstance = new CustomerApi(defaultClient);
    try {
      List<User> result = apiInstance.getAllCustomers();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CustomerApi#getAllCustomers");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;User&gt;**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/xml, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | For successful fetch. |  -  |

<a name="getCardsByCustomerId"></a>
# **getCardsByCustomerId**
> Card getCardsByCustomerId(id)

Returns all customer&#39;s cards

Returns all customer&#39;s cards based on given customer ID

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.CustomerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:8080");

    CustomerApi apiInstance = new CustomerApi(defaultClient);
    String id = "id_example"; // String | Customer Identifier
    try {
      Card result = apiInstance.getCardsByCustomerId(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CustomerApi#getCardsByCustomerId");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Customer Identifier |

### Return type

[**Card**](Card.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/xml, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | For successful fetch. |  -  |

<a name="getCustomerById"></a>
# **getCustomerById**
> User getCustomerById(id)

Returns a customer

Returns a customers identifiable by given ID

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.CustomerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:8080");

    CustomerApi apiInstance = new CustomerApi(defaultClient);
    String id = "id_example"; // String | Customer Identifier
    try {
      User result = apiInstance.getCustomerById(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CustomerApi#getCustomerById");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Customer Identifier |

### Return type

[**User**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/xml, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | For successful fetch. |  -  |

