package com.ecomm.api.backend.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.security.core.GrantedAuthority;

public enum RoleEnum implements GrantedAuthority {
    USER(Const.User),
    ADMIN(Const.Admin),
    CSR(Const.CSR);

    private String authority;

    RoleEnum(String authority) {
        this.authority = authority;
    }

    @JsonCreator
    public static RoleEnum fromAuthority(String authority) {
        for (RoleEnum role : RoleEnum.values()) {
            if (role.getAuthority().equals(authority)) {
                return role;
            }
        }
        ;
        throw new IllegalArgumentException("Invalid authority: " + authority);
    }

    @Override
    @JsonValue
    public String getAuthority() {
        return authority;
    }

    @Override
    public String toString() {
        return "RoleEnum{" +
                "authority='" + authority + '\'' +
                '}';
    }

    public class Const {
        public static final String User = "ROLE_USER";
        public static final String Admin = "ROLE_ADMIN";
        public static final String CSR = "ROLE_CSR";
    }

}
