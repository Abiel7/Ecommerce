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


package org.openapitools.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import org.threeten.bp.LocalDate;

/**
 * Shipment
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-03-03T22:36:02.048298400+01:00[Europe/Berlin]")
public class Shipment {
  public static final String SERIALIZED_NAME_ORDER_ID = "orderId";
  @SerializedName(SERIALIZED_NAME_ORDER_ID)
  private String orderId;

  public static final String SERIALIZED_NAME_CARRIER = "carrier";
  @SerializedName(SERIALIZED_NAME_CARRIER)
  private String carrier;

  public static final String SERIALIZED_NAME_TRACKING_NUMBER = "trackingNumber";
  @SerializedName(SERIALIZED_NAME_TRACKING_NUMBER)
  private String trackingNumber;

  public static final String SERIALIZED_NAME_EST_DELIVERY_DATE = "estDeliveryDate";
  @SerializedName(SERIALIZED_NAME_EST_DELIVERY_DATE)
  private LocalDate estDeliveryDate;


  public Shipment orderId(String orderId) {
    
    this.orderId = orderId;
    return this;
  }

   /**
   * Order Identifier
   * @return orderId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Order Identifier")

  public String getOrderId() {
    return orderId;
  }


  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }


  public Shipment carrier(String carrier) {
    
    this.carrier = carrier;
    return this;
  }

   /**
   * Shipping Carrier
   * @return carrier
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Shipping Carrier")

  public String getCarrier() {
    return carrier;
  }


  public void setCarrier(String carrier) {
    this.carrier = carrier;
  }


  public Shipment trackingNumber(String trackingNumber) {
    
    this.trackingNumber = trackingNumber;
    return this;
  }

   /**
   * Shipping Tracking Number
   * @return trackingNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Shipping Tracking Number")

  public String getTrackingNumber() {
    return trackingNumber;
  }


  public void setTrackingNumber(String trackingNumber) {
    this.trackingNumber = trackingNumber;
  }


  public Shipment estDeliveryDate(LocalDate estDeliveryDate) {
    
    this.estDeliveryDate = estDeliveryDate;
    return this;
  }

   /**
   * Estimated Delivery Date
   * @return estDeliveryDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Estimated Delivery Date")

  public LocalDate getEstDeliveryDate() {
    return estDeliveryDate;
  }


  public void setEstDeliveryDate(LocalDate estDeliveryDate) {
    this.estDeliveryDate = estDeliveryDate;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Shipment shipment = (Shipment) o;
    return Objects.equals(this.orderId, shipment.orderId) &&
        Objects.equals(this.carrier, shipment.carrier) &&
        Objects.equals(this.trackingNumber, shipment.trackingNumber) &&
        Objects.equals(this.estDeliveryDate, shipment.estDeliveryDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId, carrier, trackingNumber, estDeliveryDate);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Shipment {\n");
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    carrier: ").append(toIndentedString(carrier)).append("\n");
    sb.append("    trackingNumber: ").append(toIndentedString(trackingNumber)).append("\n");
    sb.append("    estDeliveryDate: ").append(toIndentedString(estDeliveryDate)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

