package com.ecomm.api.backend.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.*;
import org.springframework.boot.autoconfigure.web.WebProperties;
import reactor.core.publisher.Mono;

import javax.validation.constraints.NotNull;
import java.util.Map;
import java.util.Objects;

@Component
@Order(-2) //prioritization, with the first object (with the lowest order value) having the highest priority.
public class ApiErrorWebExceptionHandler extends AbstractErrorWebExceptionHandler  {

        public ApiErrorWebExceptionHandler(ApiErrorsAttributes errorsAttributes,
                                           ApplicationContext applicationContext,
                                           ServerCodecConfigurer serverCodecConfigurer){
            super(errorsAttributes, new WebProperties().getResources(),applicationContext);
            super.setMessageWriters(serverCodecConfigurer.getWriters());
            super.setMessageReaders(serverCodecConfigurer.getReaders());

        }

    @Override
    protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
        return RouterFunctions.route(RequestPredicates.all(),this::renderErrorResponse);
    }

    private Mono<ServerResponse> renderErrorResponse (ServerRequest serverRequest) {
        Map<String, Object> errorAttributes= getErrorAttributes(serverRequest, ErrorAttributeOptions.defaults());
         return  null;
    }
}
