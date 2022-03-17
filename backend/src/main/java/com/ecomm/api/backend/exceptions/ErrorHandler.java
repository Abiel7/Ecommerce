package com.ecomm.api.backend.exceptions;


import com.fasterxml.jackson.core.JsonParseException;
import org.apache.tomcat.jni.Local;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

import static javax.xml.transform.OutputKeys.MEDIA_TYPE;

/**
 * by marking this class with @ControllerAdvice it  will trace all
 * the request and response processing By the controller
 * it also has the ability to handle exception  by marking it with
 * @ExceptionHandler
 * every time an  exception  occurs on of ths exception tagged  with  specific exception    will be  triggered and  show  human-readable  errors
 */
@ControllerAdvice
public class ErrorHandler {

    private final Logger log= LoggerFactory.getLogger(ErrorHandler.class);

    private final MessageSource messageSource;

    @Autowired
   public ErrorHandler(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    /*
    A Locale object represents a specific geographical, political, or cultural region.
    * */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handelException(HttpServletRequest request, Exception exception, Locale locale){
        exception.printStackTrace();
        Error error = ErrorUtils
                .createError(ErrorCode.GENERIC_ERROR.getErrMsgKey(), ErrorCode.GENERIC_ERROR.getErrCode(),
                        HttpStatus.INTERNAL_SERVER_ERROR.value())
                .setUrl(request.getRequestURI().toString())
                .setReqMethod(request.getMethod());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);

    }
    /**
     * The HTTP 415 Unsupported Media Type client error response code indicates
     * that the server refuses to accept the request because the payload format is in an unsupported format.
     * mdn
     */
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<Error> handleHttpMediaTypeNotSupportedException(HttpServletRequest request, HttpMediaTypeNotSupportedException exception, Locale locale){
        exception.printStackTrace();
        Error error = ErrorUtils.createError(ErrorCode.HTTP_MEDIA_TYPE_NOT_SUPPORTED.getErrMsgKey(),
                ErrorCode.HTTP_MEDIA_TYPE_NOT_SUPPORTED.getErrCode(),HttpStatus.UNSUPPORTED_MEDIA_TYPE.value())
                .setUrl(request.getRequestURI().toString())
                .setReqMethod(request.getMethod());

        return  new ResponseEntity<Error>(error,HttpStatus.INTERNAL_SERVER_ERROR);

    }

    /**
     *  typically  this exception occurs when  spring fails to fetch the properties of returned object
     *  The most typical cause of this exception is usually that the returned object doesn't have any
     *  public getter methods for its properties.
     */
    @ExceptionHandler(HttpMessageNotWritableException.class)
    public ResponseEntity<Error> handelHttpMessageNotWritableException(HttpServletRequest request, HttpMessageNotWritableException exception, Locale locale){
        exception.printStackTrace();
        Error error = ErrorUtils.createError(ErrorCode.HTTP_MESSAGE_NOT_WRITABLE.getErrMsgKey(),
                ErrorCode.HTTP_MESSAGE_NOT_WRITABLE.getErrCode(),HttpStatus.INTERNAL_SERVER_ERROR.value())
                .setUrl(request.getRequestURI().toString())
                .setReqMethod(request.getMethod());

        return  new ResponseEntity<Error>(error,HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public ResponseEntity<Error> handelHttpMediaTypeNotAcceptableException(HttpServletRequest request, HttpMediaTypeNotAcceptableException exception, Locale locale){
        exception.printStackTrace();
        Error error = ErrorUtils.createError(ErrorCode.HTTP_MEDIA_TYPE_NOT_ACCEPTABLE.getErrMsgKey(),
                ErrorCode.HTTP_MEDIA_TYPE_NOT_ACCEPTABLE.getErrCode(),HttpStatus.NOT_ACCEPTABLE.value())
                .setUrl(request.getRequestURI().toString())
                .setReqMethod(request.getMethod());

        return  new ResponseEntity<Error>(error,HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Error> handelHttpMessageNotReadableException(HttpServletRequest request, HttpMessageNotReadableException exception, Locale locale){
        exception.printStackTrace();
        Error error = ErrorUtils.createError(ErrorCode.HTTP_MESSAGE_NOT_READABLE.getErrMsgKey(),
                ErrorCode.HTTP_MESSAGE_NOT_READABLE.getErrCode(),HttpStatus.BAD_REQUEST.value())
                .setUrl(request.getRequestURI().toString())
                .setReqMethod(request.getMethod());

        return  new ResponseEntity<Error>(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(JsonParseException.class)
    public ResponseEntity<Error> handelJsonParseException(HttpServletRequest request, JsonParseException exception, Locale locale){
        exception.printStackTrace();
        Error error = ErrorUtils.createError(ErrorCode.JSON_PARSE_ERROR.getErrMsgKey(),
                ErrorCode.JSON_PARSE_ERROR.getErrCode(),HttpStatus.BAD_REQUEST.value())
                .setUrl(request.getRequestURI().toString())
                .setReqMethod(request.getMethod());

        return  new ResponseEntity<Error>(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }


    public static void main(String[] args) {
        Locale locale =  new Locale("no","NORWAY","NY");
        System.out.println(locale);
    }


}
