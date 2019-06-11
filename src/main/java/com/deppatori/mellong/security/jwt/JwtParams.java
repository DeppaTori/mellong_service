package com.deppatori.mellong.security.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtParams {

    @Value("${jwt.auth.login.url}")
    private String authLoginUrl;

    public String getAuthLoginUrl() {
        return authLoginUrl;
    }


}
