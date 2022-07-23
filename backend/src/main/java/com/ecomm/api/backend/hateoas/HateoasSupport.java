package com.ecomm.api.backend.hateoas;

import org.springframework.http.server.PathContainer;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.util.annotation.Nullable;

import org.springframework.http.server.reactive.ServerHttpRequest;

import javax.validation.constraints.NotNull;


/**
 *  this interface has one default method which can be used to extract the server URI.
 *  This interface is used for getting the http request response etc.
 *  https://www.baeldung.com/spring-uricomponentsbuilder
 */
public interface HateoasSupport {

    default UriComponentsBuilder getUriComponentsBuilder(@Nullable ServerWebExchange exchange) {
        if(exchange == null) {
            return UriComponentsBuilder.fromPath("/");
        }
        ServerHttpRequest request = exchange.getRequest();
        PathContainer pathContainer = request.getPath().contextPath();

        System.out.println("pathContainer: " + pathContainer);

        return UriComponentsBuilder.fromHttpRequest(request)
                .replacePath(pathContainer.toString())
                .replaceQuery("");
    }
}
