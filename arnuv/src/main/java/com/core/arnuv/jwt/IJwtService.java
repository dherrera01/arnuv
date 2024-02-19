package com.core.arnuv.jwt;

import io.jsonwebtoken.Claims;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

public interface IJwtService {
    String extractUserName(String token);

    HttpHeaders generaToken(Map<String, Object> extraClaims, UserDetails userDetails);

    HttpHeaders regeneraToken();

    boolean isTokenValid(String token, UserDetails userDetails);

    Claims extraerTokenData();

    void setTokenSession(String token);

    String getTokenSession();
}
