package com.ecomm.api.backend.exceptions;

public class ErrorUtils {

    private ErrorUtils(){}

    public static Error createError(String errMsgKey,String errorCode,Integer httpStatus){
        Error error =  new Error();
        error.setMessage(errMsgKey);
        error.setErrorCode(errorCode);
        error.setStatus(httpStatus);
        return error;
    }
}
