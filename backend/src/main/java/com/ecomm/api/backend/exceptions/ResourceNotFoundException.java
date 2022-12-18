package com.ecomm.api.backend.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private final String errMsgkKey;
    private final String errorCode;


    public ResourceNotFoundException(ErrorCode code) {
        super(code.getErrMsgKey());
        this.errMsgkKey = code.getErrMsgKey();
        this.errorCode = code.getErrCode();
    }


    public ResourceNotFoundException(final String message){
        super(message);
        this.errMsgkKey =ErrorCode.RESOURCE_NOT_FOUND.getErrMsgKey();
        this.errorCode =ErrorCode.RESOURCE_NOT_FOUND.getErrCode();
    }

    public String getErrMsgKey() {
        return errMsgkKey;
    }

    public String getErrorCode() {
        return errorCode;
    }

}
