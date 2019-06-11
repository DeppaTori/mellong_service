package com.deppatori.mellong.security.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtParams {

    @Value("${jwt.auth.login.url}")
    private String authLoginUrl;

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.token.header}")
    private String tokenHeader;

    @Value("${jwt.token.prefix}")
    private String tokenPrefix;

    @Value("${jwt.token.type}")
    private String tokenType;

    @Value("${jwt.token.issuer}")
    private String tokenIssuer;

    @Value("${jwt.token.audience}")
    private String tokenAudience;

    public String getAuthLoginUrl() {
        return authLoginUrl;
    }

    public String getSecret() {
        return secret;
    }

    public String getTokenHeader() {
        return tokenHeader;
    }

    public String getTokenPrefix() {
        return tokenPrefix;
    }

    public String getTokenType() {
        return tokenType;
    }

    public String getTokenIssuer() {
        return tokenIssuer;
    }

    public String getTokenAudience() {
        return tokenAudience;
    }
}
