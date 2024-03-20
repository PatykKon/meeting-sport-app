package com.meeting.sport.app.user;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum Role {

    USER("USER"),
    OWNER("OWNER"),
    ADMIN("ADMIN");


    private final String permissions;

    Role(String permissions) {
        this.permissions = permissions;
    }

    public SimpleGrantedAuthority getAuth() {
        return new SimpleGrantedAuthority("ROLE_" + permissions);
    }

    public String getPermissions() {
        return permissions;
    }
}
