package com.ecomm.api.backend.exceptions;


import lombok.Data;
import org.apache.logging.log4j.util.Strings;


@Data
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

}
