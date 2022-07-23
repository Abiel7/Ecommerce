package com.ecomm.api.backend.exceptions;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.*;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.web.server.ServerWebInputException;
import reactor.core.publisher.Mono;

import java.util.Map;


import static com.ecomm.api.backend.exceptions.ErrorCode.*;

@Component
@Order(-2) //prioritization, with the first object (with the lowest order value) having the highest priority.
@EnableAutoConfiguration
public class ApiErrorWebExceptionHandler extends AbstractErrorWebExceptionHandler  {


    public ApiErrorWebExceptionHandler(ApiErrorsAttributes apiErrorsAttributes,
                                       ServerCodecConfigurer serverCodecConfigurer,
                                       ApplicationContext applicationContext
                                       ) {
       super(apiErrorsAttributes, new WebProperties().getResources(),applicationContext);
       super.setMessageWriters(serverCodecConfigurer.getWriters());
         super.setMessageReaders(serverCodecConfigurer.getReaders());
    }

    @Override
    protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
        return RouterFunctions.route(RequestPredicates.all(),this::renderErrorResponse);
    }

    private Mono<ServerResponse> renderErrorResponse (ServerRequest serverRequest) {
        Map<String, Object> errorAttributes= getErrorAttributes(serverRequest, ErrorAttributeOptions.defaults());

        for (Map.Entry<String, Object> entry : errorAttributes.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
         Throwable throwable = (Throwable) serverRequest
                 .attribute("org.springframework.boot.web.reactive.error.DefaultErrorAttributes.ERROR")
                 .orElseThrow(
                         () -> new IllegalStateException("ErrorAttributes not found in ServerRequest")
                 );
         throwable.printStackTrace();
         ErrorCode errorCode = ErrorCode.GENERIC_ERROR;
         if(throwable instanceof IllegalArgumentException
                 || throwable instanceof DataIntegrityViolationException
                 || throwable instanceof ServerWebInputException) {
             errorCode = ILLEGAL_ARGUMENT_EXCEPTION;
         }
         else if (throwable instanceof  CustomerNotFoundException){
             errorCode = CUSTOMER_NOT_FOUND;
         }
         else if (throwable instanceof  ResourceNotFoundException) {
             errorCode = RESOURCE_NOT_FOUND;
         }
         else if (throwable instanceof CardAlreadyExistsException) {
             errorCode = CARD_ALREADY_EXISTS;
         }
         else if (throwable instanceof GenericAlreadyExistsException){
              errorCode = GENERIC_ALREADY_EXISTS;
         }

         switch (errorCode) {
             case ILLEGAL_ARGUMENT_EXCEPTION -> {
                 errorAttributes.put("status", HttpStatus.BAD_REQUEST);
                 errorAttributes.put("code", ILLEGAL_ARGUMENT_EXCEPTION.getErrCode());
                 errorAttributes.put("error",ILLEGAL_ARGUMENT_EXCEPTION);
                 errorAttributes.put("message", String.format("%s: %s", ILLEGAL_ARGUMENT_EXCEPTION.getErrMsgKey(),throwable.getMessage()));
                 return ServerResponse.status(HttpStatus.BAD_REQUEST)
                         .contentType(MediaType.APPLICATION_JSON)
                         .body(BodyInserters.fromValue(errorAttributes));
             }
                case CUSTOMER_NOT_FOUND -> {
                    errorAttributes.put("status", HttpStatus.NOT_FOUND);
                    errorAttributes.put("code", CUSTOMER_NOT_FOUND.getErrCode());
                    errorAttributes.put("error",CUSTOMER_NOT_FOUND);
                    errorAttributes.put("message", String.format("%s: %s", CUSTOMER_NOT_FOUND.getErrMsgKey(),throwable.getMessage()));
                    return ServerResponse.status(HttpStatus.NOT_FOUND)
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(BodyInserters.fromValue(errorAttributes));
                }

                case RESOURCE_NOT_FOUND -> {
                    errorAttributes.put("status", HttpStatus.NOT_FOUND);
                    errorAttributes.put("code", RESOURCE_NOT_FOUND.getErrCode());
                    errorAttributes.put("error",RESOURCE_NOT_FOUND);
                    errorAttributes.put("message", String.format("%s: %s", RESOURCE_NOT_FOUND.getErrMsgKey(),throwable.getMessage()));
                    return ServerResponse.status(HttpStatus.NOT_FOUND)
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(BodyInserters.fromValue(errorAttributes));
                }

                case CARD_ALREADY_EXISTS -> {
                    errorAttributes.put("status", HttpStatus.CONFLICT);
                    errorAttributes.put("code", CARD_ALREADY_EXISTS.getErrCode());
                    errorAttributes.put("error",CARD_ALREADY_EXISTS);
                    errorAttributes.put("message", String.format("%s: %s", CARD_ALREADY_EXISTS.getErrMsgKey(),throwable.getMessage()));
                    return ServerResponse.status(HttpStatus.NOT_ACCEPTABLE)
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(BodyInserters.fromValue(errorAttributes));
                }

                case GENERIC_ALREADY_EXISTS -> {
                    errorAttributes.put("status", HttpStatus.CONFLICT);
                    errorAttributes.put("code", GENERIC_ALREADY_EXISTS.getErrCode());
                    errorAttributes.put("error",GENERIC_ALREADY_EXISTS);
                    errorAttributes.put("message", String.format("%s: %s", GENERIC_ALREADY_EXISTS.getErrMsgKey(),throwable.getMessage()));
                    return ServerResponse.status(HttpStatus.NOT_ACCEPTABLE)
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(BodyInserters.fromValue(errorAttributes));
                }

             default -> ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
                     .contentType(MediaType.APPLICATION_JSON)
                     .body(BodyInserters.fromValue(errorAttributes));

         }
        return ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(errorAttributes));
    }
}
