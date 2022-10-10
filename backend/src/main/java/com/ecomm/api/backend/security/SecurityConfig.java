package com.ecomm.api.backend.security;

import com.ecomm.api.backend.security.Handlers.ApiAccessDeniedHandler;
import com.ecomm.api.backend.security.Handlers.ApiAuthenticationEntryPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private UserDetailsService userDetailsService;
    private PasswordEncoder bCryptPasswordEncoder;
    private ApiAccessDeniedHandler apiAccessDeniedHandler;
    private ApiAuthenticationEntryPoint apiAuthenticationEntryPoint;
    private FilterChai


}
