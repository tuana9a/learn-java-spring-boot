package com.tuana9a.learn.java.springboot.services;

import com.tuana9a.learn.java.springboot.entities.User;

public interface SocialService {
    String createAuthorizationURL();
            
    String createAccessToken(String code) throws Exception;
            
    User getUserInfoByToken(String token) throws Exception;
}
