package com.tuana9a.learn.java.springboot.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tuana9a.learn.java.springboot.entities.User;
import com.tuana9a.learn.java.springboot.dto.GooglePojo;
import org.apache.http.client.fluent.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Service;

@Service
public class GoogleService implements SocialService {


    @Value("${google.appId}")
    private String appId;

    @Value("${google.appSecret}")
    private String appSecret;

    @Value("${google.redirect}")
    private String redirect;

    @Value("${google.user_info}")
    private String urlToGetUserInfo;

    @Value("${google.scope}")
    private String scope;

    @Override
    public String createAuthorizationURL() {
        GoogleConnectionFactory connectionFactory = new GoogleConnectionFactory(appId, appSecret);
        OAuth2Operations oauthOperations = connectionFactory.getOAuthOperations();
        OAuth2Parameters params = new OAuth2Parameters();
        params.setRedirectUri(redirect);
        params.setScope(scope);
        return oauthOperations.buildAuthorizeUrl(params);
    }

    @Override
    public String createAccessToken(String code) throws Exception {
        return new GoogleConnectionFactory(appId, appSecret).getOAuthOperations()
                .exchangeForAccess(code, redirect, null)
                .getAccessToken();
    }

    @Override
    public User getUserInfoByToken(String token) throws Exception {
        String url = urlToGetUserInfo + token; // tạo link api
        String response = Request.Get(url)
                .execute()
                .returnContent()
                .asString(); // call api
        GooglePojo pojo = new ObjectMapper().readValue(response, GooglePojo.class); // map với entity

        return User.builder() // tạo user mới
                .googleId(pojo.getId())
                .username(pojo.getEmail())
                .name(pojo.getName())
                .password("")
                .deleted(false)
                .build();

    }
}
