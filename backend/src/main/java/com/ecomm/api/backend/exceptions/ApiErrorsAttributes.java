package com.ecomm.api.backend.exceptions;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.util.Map;

/*
defultErrorAtributes is  a default  implementation of  errorAttributes: an interface   that provides a
way to handle map, a ma of error fields and their values. these error attributes can be used for displaying an error to users or for
 logging

  in reactive stream you have to raise the expectation yourself.
 */
@Component
public class ApiErrorsAttributes extends DefaultErrorAttributes {
    private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
    private String message = ErrorCode.GENERIC_ERROR.getErrMsgKey();


    @Override
    public Map<String, Object> getErrorAttributes(ServerRequest request, ErrorAttributeOptions options) {
        Map<String, Object> attributes = super.getErrorAttributes(request, options);
        attributes.put("status", status);
        attributes.put("message", message);
        attributes.put("code", ErrorCode.GENERIC_ERROR.getErrCode());

        return attributes;
    }


    public HttpStatus getStatus() {
        return this.status;
    }

    public ApiErrorsAttributes setStatus(HttpStatus status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return this.message;
    }

    public ApiErrorsAttributes setMessage(String message) {
        this.message = message;
        return this;
    }
}
