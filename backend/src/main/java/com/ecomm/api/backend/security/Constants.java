package com.ecomm.api.backend.security;

public class Constants {
    //password hashing function
    public static final String ENCODED_id = "bcrypt";
    public static final String API_URL_PREFIX = "/api/v1/**";
    public static final String H2_URL_PREFIX = "/h2-console/**";
    public static final String SIGN_UP_URL = "/api/v1/users";
    public static final String TOKEN_URL = "/api/v1/auth/token";
    public static final String REFRESH_TOKEN_URL = "/api/v1/auth/token/refresh";
    public static final String PRODUCT_URL = "/api/v1/products/**";
    public static final String AUTHORIZATION = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer";
    public static final String SECRET_KEY = "SECRET_KEY";
    public static final long EXPIRATION_TIME = 900_000; // 15 minutes
    public static final String ROLE = "roles";
    public static final String AUTHORITY_PREFIX = "ROLE_";
}
