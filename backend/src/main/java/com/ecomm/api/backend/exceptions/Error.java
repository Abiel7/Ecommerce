package com.ecomm.api.backend.exceptions;


import lombok.Data;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;



public class Error {

    /*App error code */
    private String errorCode;
    /*readable response */
    private String message;
    /*Http status  code */
    private Integer status;

    private String url = "Not available";
    private String reqMethod = "Not available";


    public Error setUrl(String url) {
        if(Strings.isBlank((url))){
            this.url = url;
        }
        return this;
    }

    public Error setReqMethod(String method){
        if(Strings.isBlank(method)){
            this.reqMethod = method;
        }
        return  this;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public String getReqMethod() {
        return reqMethod;
    }
}
