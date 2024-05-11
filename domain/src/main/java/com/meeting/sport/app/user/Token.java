package com.meeting.sport.app.user;

public class Token {

    private Long id;
    private String token;

    private final TokenType tokenType;
    private boolean revoked;
    private boolean expired;

    private User user;

    public Token(Long id, String token, boolean revoked, boolean expired, User user) {
        this.id = id;
        this.token = token;
        this.tokenType = TokenType.BEARER;
        this.revoked = revoked;
        this.expired = expired;
        this.user = user;
    }

    private Token(String token, boolean revoked, boolean expired, User user) {
        this.token = token;
        this.tokenType = TokenType.BEARER;
        this.revoked = revoked;
        this.expired = expired;
        this.user = user;
    }

    public static Token createToken(User user, String jwtToken){

        return new Token(jwtToken,false,false,user);

    }

    public void changeExpired(){
        this.expired = true;
    }
    public void changeRevoked(){
        this.revoked = true;
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
