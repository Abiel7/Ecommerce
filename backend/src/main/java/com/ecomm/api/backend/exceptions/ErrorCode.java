package com.ecomm.api.backend.exceptions;


public enum ErrorCode {
    GENERIC_ERROR("ERROR-0001","System Error"),
    HTTP_MEDIA_TYPE_NOT_SUPPORTED("ERROR-0002","Media Type Not Supported "),
    HTTP_MESSAGE_NOT_WRITABLE("ERROR-0003","Missing Accept header "),
    HTTP_MEDIA_TYPE_NOT_ACCEPTABLE("ERROR-0004","use application/xml or application/json as accept value"),
    JSON_PARSE_ERROR("ERROR-0005","Not Valid Json object "),
    HTTP_MESSAGE_NOT_READABLE("ERROR-0006","Not valid JSON or XML object");

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
