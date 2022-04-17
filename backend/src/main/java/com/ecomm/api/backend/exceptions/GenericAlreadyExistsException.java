package com.ecomm.api.backend.exceptions;

public class GenericAlreadyExistsException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private final String errMsgkKey;
    private final String errorCode;

    public GenericAlreadyExistsException(ErrorCode code) {
        super(code.getErrMsgKey());
        this.errMsgkKey = code.getErrMsgKey();
        this.errorCode = code.getErrCode();
    }
    public GenericAlreadyExistsException( final String message) {
        super(message);
        this.errMsgkKey = ErrorCode.GENERIC_ERROR.getErrMsgKey();
        this.errorCode = ErrorCode.GENERIC_ERROR.getErrCode();
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrMsgkKey() {
        return errMsgkKey;
    }


}
