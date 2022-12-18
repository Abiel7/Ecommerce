package com.ecomm.api.backend.exceptions;


public enum ErrorCode {
    GENERIC_ERROR("ERROR-0001","System Error"),
    HTTP_MEDIA_TYPE_NOT_SUPPORTED("ERROR-0002","Media Type Not Supported "),
    HTTP_MESSAGE_NOT_WRITABLE("ERROR-0003","Missing Accept header "),
    HTTP_MEDIA_TYPE_NOT_ACCEPTABLE("ERROR-0004","use application/xml or application/json as accept value"),
    JSON_PARSE_ERROR("ERROR-0005","Not Valid Json object "),
    HTTP_MESSAGE_NOT_READABLE("ERROR-0006","Not valid JSON or XML object"),
    HTTP_REQUEST_METHOD_NOT_SUPPORTED("ERROR-0007", "Request method not supported."),
    CONSTRAINT_VIOLATION("ERROR-0008", "Validation failed."),
    ILLEGAL_ARGUMENT_EXCEPTION("ERROR-0009", "Invalid data passed."),
    RESOURCE_NOT_FOUND("ERROR-0010", "Requested resource not found"),
    CUSTOMER_NOT_FOUND("ERROR-0011", "Requested customer not found"),
    ITEM_NOT_FOUND("ERROR-0012", "Requested item not found"),
    GENERIC_ALREADY_EXISTS("ERROR-0013", "Already exists."),
    CARD_ALREADY_EXISTS("ERROR-0013","Card Already Exists");
    private final String errCode;
    private final String errMsgKey;

    ErrorCode(String errCode,String errMsgKey){
        this.errCode=errCode;
        this.errMsgKey=errMsgKey;
    }

    public String getErrCode() {
        return errCode;
    }

    public String getErrMsgKey() {
        return errMsgKey;
    }
}
