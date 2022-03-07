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
import java.util.ArrayList;
import java.util.List;
import org.openapitools.client.model.Address;
import org.openapitools.client.model.Card;
import org.openapitools.client.model.Item;
import org.openapitools.client.model.Payment;
import org.openapitools.client.model.Shipment;
import org.openapitools.client.model.User;
import org.threeten.bp.OffsetDateTime;

/**
 * Represents an order
 */
@ApiModel(description = "Represents an order")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-03-03T22:36:02.048298400+01:00[Europe/Berlin]")
public class Order {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_CUSTOMER = "customer";
  @SerializedName(SERIALIZED_NAME_CUSTOMER)
  private User customer;

  public static final String SERIALIZED_NAME_ADDRESS = "address";
  @SerializedName(SERIALIZED_NAME_ADDRESS)
  private Address address;

  public static final String SERIALIZED_NAME_CARD = "card";
  @SerializedName(SERIALIZED_NAME_CARD)
  private Card card;

  public static final String SERIALIZED_NAME_DATE = "date";
  @SerializedName(SERIALIZED_NAME_DATE)
  private OffsetDateTime date;

  public static final String SERIALIZED_NAME_ITEMS = "items";
  @SerializedName(SERIALIZED_NAME_ITEMS)
  private List<Item> items = null;

  public static final String SERIALIZED_NAME_TOTAL = "total";
  @SerializedName(SERIALIZED_NAME_TOTAL)
  private Double total;

  public static final String SERIALIZED_NAME_PAYMENT = "payment";
  @SerializedName(SERIALIZED_NAME_PAYMENT)
  private Payment payment;

  public static final String SERIALIZED_NAME_SHIPMENT = "shipment";
  @SerializedName(SERIALIZED_NAME_SHIPMENT)
  private Shipment shipment;

  /**
   * Order Status
   */
  @JsonAdapter(StatusEnum.Adapter.class)
  public enum StatusEnum {
    CREATED("CREATED"),
    
    PAID("PAID"),
    
    SHIPPED("SHIPPED"),
    
    PAYMENT_FAILED("PAYMENT_FAILED"),
    
    SHIPMENT_FAILED("SHIPMENT_FAILED"),
    
    COMPLETED("COMPLETED");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<StatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public StatusEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return StatusEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_STATUS = "status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  private StatusEnum status;


  public Order id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * Order identifier
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Order identifier")

  public String getId() {
    return id;
  }


  public void setId(String id) {
    this.id = id;
  }


  public Order customer(User customer) {
    
    this.customer = customer;
    return this;
  }

   /**
   * Get customer
   * @return customer
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public User getCustomer() {
    return customer;
  }


  public void setCustomer(User customer) {
    this.customer = customer;
  }


  public Order address(Address address) {
    
    this.address = address;
    return this;
  }

   /**
   * Get address
   * @return address
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Address getAddress() {
    return address;
  }


  public void setAddress(Address address) {
    this.address = address;
  }


  public Order card(Card card) {
    
    this.card = card;
    return this;
  }

   /**
   * Get card
   * @return card
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Card getCard() {
    return card;
  }


  public void setCard(Card card) {
    this.card = card;
  }


  public Order date(OffsetDateTime date) {
    
    this.date = date;
    return this;
  }

   /**
   * Order&#39;s data and time details
   * @return date
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Order's data and time details")

  public OffsetDateTime getDate() {
    return date;
  }


  public void setDate(OffsetDateTime date) {
    this.date = date;
  }


  public Order items(List<Item> items) {
    
    this.items = items;
    return this;
  }

  public Order addItemsItem(Item itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<Item>();
    }
    this.items.add(itemsItem);
    return this;
  }

   /**
   * Collection of order items.
   * @return items
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Collection of order items.")

  public List<Item> getItems() {
    return items;
  }


  public void setItems(List<Item> items) {
    this.items = items;
  }


  public Order total(Double total) {
    
    this.total = total;
    return this;
  }

   /**
   * Order total
   * @return total
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Order total")

  public Double getTotal() {
    return total;
  }


  public void setTotal(Double total) {
    this.total = total;
  }


  public Order payment(Payment payment) {
    
    this.payment = payment;
    return this;
  }

   /**
   * Get payment
   * @return payment
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Payment getPayment() {
    return payment;
  }


  public void setPayment(Payment payment) {
    this.payment = payment;
  }


  public Order shipment(Shipment shipment) {
    
    this.shipment = shipment;
    return this;
  }

   /**
   * Get shipment
   * @return shipment
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Shipment getShipment() {
    return shipment;
  }


  public void setShipment(Shipment shipment) {
    this.shipment = shipment;
  }


  public Order status(StatusEnum status) {
    
    this.status = status;
    return this;
  }

   /**
   * Order Status
   * @return status
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Order Status")

  public StatusEnum getStatus() {
    return status;
  }


  public void setStatus(StatusEnum status) {
    this.status = status;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Order order = (Order) o;
    return Objects.equals(this.id, order.id) &&
        Objects.equals(this.customer, order.customer) &&
        Objects.equals(this.address, order.address) &&
        Objects.equals(this.card, order.card) &&
        Objects.equals(this.date, order.date) &&
        Objects.equals(this.items, order.items) &&
        Objects.equals(this.total, order.total) &&
        Objects.equals(this.payment, order.payment) &&
        Objects.equals(this.shipment, order.shipment) &&
        Objects.equals(this.status, order.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, customer, address, card, date, items, total, payment, shipment, status);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Order {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    card: ").append(toIndentedString(card)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    payment: ").append(toIndentedString(payment)).append("\n");
    sb.append("    shipment: ").append(toIndentedString(shipment)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

