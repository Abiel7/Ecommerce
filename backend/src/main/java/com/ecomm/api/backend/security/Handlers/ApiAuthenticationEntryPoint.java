package com.ecomm.api.backend.security.Handlers;

import com.ecomm.api.backend.exceptions.Error;
import com.ecomm.api.backend.exceptions.ErrorCode;
import com.ecomm.api.backend.exceptions.ErrorUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.time.Instant;

import static com.ecomm.api.backend.security.Constants.TOKEN_URL;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Component
public class ApiAuthenticationEntryPoint implements AuthenticationEntryPoint {
    private final Logger LOG = LoggerFactory.getLogger(getClass());
    private ObjectMapper mapper;

    public ApiAuthenticationEntryPoint(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        LOG.info("Exception " + authException.getMessage());
        LOG.info("Cause " + authException.getCause());

        String errorMessage = "";
        if (authException instanceof InsufficientAuthenticationException) {
            errorMessage = "Full authentication is required to access this resource";
        } else {
            errorMessage = ErrorCode.UNAUTHORIZED.getErrMsgKey();
        }

        Error error = ErrorUtils
                .createError(errorMessage, ErrorCode.UNAUTHORIZED.getErrCode(), HttpStatus.UNAUTHORIZED.value())
                .setUrl(TOKEN_URL)
                .setReqMethod(request.getMethod())
                .setTimeStamp(Instant.now());
        response.setContentType(APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");
        OutputStream out = response.getOutputStream();
        mapper.writeValue(out, error);
        out.flush();

    }
}
