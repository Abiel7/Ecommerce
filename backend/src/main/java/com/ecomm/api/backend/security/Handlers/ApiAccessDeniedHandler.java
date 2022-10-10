package com.ecomm.api.backend.security.Handlers;

import com.ecomm.api.backend.exceptions.Error;
import com.ecomm.api.backend.exceptions.ErrorCode;
import com.ecomm.api.backend.exceptions.ErrorUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.time.Instant;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Component
public class ApiAccessDeniedHandler implements AccessDeniedHandler {
    private final Logger LOG = LoggerFactory.getLogger(getClass());
    private ObjectMapper mapper;

    public ApiAccessDeniedHandler(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        Error error = ErrorUtils
                .createError(ErrorCode.ACCESS_DENIED.getErrMsgKey(),
                        ErrorCode.ACCESS_DENIED.getErrCode(),
                        HttpStatus.FORBIDDEN.value())
                .setReqMethod(request.getMethod())
                .setTimeStamp(Instant.now());
        response.setContentType(APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");
        OutputStream out = response.getOutputStream();
        mapper.writeValue(out, error);
        out.flush();
    }
}
