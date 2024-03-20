package com.meeting.sport.app.user;

public class Token {

    private Long id;
    private String token;
    private boolean revoked;
    private boolean expired;

    private User user;

    public Token(Long id, String token, boolean revoked, boolean expired, User user) {
        this.id = id;
        this.token = token;
        this.revoked = revoked;
        this.expired = expired;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public boolean isRevoked() {
        return revoked;
    }

    public boolean isExpired() {
        return expired;
    }

    public User getUser() {
        return user;
    }
}
