package com.diplom.diplom.dataBase.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_USER, ROLE_PSYCHOLOGIST, ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
