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

/**
 * Card
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-03-03T22:36:02.048298400+01:00[Europe/Berlin]")
public class Card {
  public static final String SERIALIZED_NAME_CARD_NUMBER = "cardNumber";
  @SerializedName(SERIALIZED_NAME_CARD_NUMBER)
  private String cardNumber;

  public static final String SERIALIZED_NAME_EXPIRES = "expires";
  @SerializedName(SERIALIZED_NAME_EXPIRES)
  private String expires;

  public static final String SERIALIZED_NAME_CCV = "ccv";
  @SerializedName(SERIALIZED_NAME_CCV)
  private String ccv;


  public Card cardNumber(String cardNumber) {
    
    this.cardNumber = cardNumber;
    return this;
  }

   /**
   * Card Number
   * @return cardNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Card Number")

  public String getCardNumber() {
    return cardNumber;
  }


  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }


  public Card expires(String expires) {
    
    this.expires = expires;
    return this;
  }

   /**
   * Expiration date
   * @return expires
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Expiration date")

  public String getExpires() {
    return expires;
  }


  public void setExpires(String expires) {
    this.expires = expires;
  }


  public Card ccv(String ccv) {
    
    this.ccv = ccv;
    return this;
  }

   /**
   * CCV code
   * @return ccv
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "CCV code")

  public String getCcv() {
    return ccv;
  }


  public void setCcv(String ccv) {
    this.ccv = ccv;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Card card = (Card) o;
    return Objects.equals(this.cardNumber, card.cardNumber) &&
        Objects.equals(this.expires, card.expires) &&
        Objects.equals(this.ccv, card.ccv);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cardNumber, expires, ccv);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Card {\n");
    sb.append("    cardNumber: ").append(toIndentedString(cardNumber)).append("\n");
    sb.append("    expires: ").append(toIndentedString(expires)).append("\n");
    sb.append("    ccv: ").append(toIndentedString(ccv)).append("\n");
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
