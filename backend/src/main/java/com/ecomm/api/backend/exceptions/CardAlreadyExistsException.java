package com.ecomm.api.backend.exceptions;

public class CardAlreadyExistsException extends RuntimeException{
    private final String  errCode;
    private final String errMsgKey;


    public CardAlreadyExistsException(final String msg){
        super(msg);
        this.errCode = ErrorCode.CARD_ALREADY_EXISTS.getErrCode();
        this.errMsgKey = ErrorCode.CARD_ALREADY_EXISTS.getErrMsgKey();
    }

    public String getErrCode () {
        return errCode;
    }

    public String getErrMsgKey(){
        return errMsgKey;

    }
}
