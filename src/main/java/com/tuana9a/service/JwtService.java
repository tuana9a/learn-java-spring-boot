package com.tuana9a.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.tuana9a.security.SecurityConstants.*;

@Service
public class JwtService {
    public String generateToken(String username) {
        return TOKEN_PREFIX + JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SECRET));
    }

    public String decodeToken(String token) {
        try {
            return JWT.require(Algorithm.HMAC512(SECRET))
                    .build().verify(token.replace(TOKEN_PREFIX, ""))
                    .getSubject();
        } catch (Exception ignored) {
        }
        return null;
    }
}
