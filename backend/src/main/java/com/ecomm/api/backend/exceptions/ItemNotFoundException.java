package com.ecomm.api.backend.exceptions;

public class ItemNotFoundException extends RuntimeException {

    public static long  serialVersionUID = 1L;

    private final String errMsgkKey;
    private final String errorCode;
    public ItemNotFoundException(String format) {
        this.errMsgkKey = ErrorCode.ITEM_NOT_FOUND.getErrMsgKey();
        this.errorCode = ErrorCode.ITEM_NOT_FOUND.getErrCode();
    }

    public String getErrMsgkKey() {
        return errMsgkKey;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
