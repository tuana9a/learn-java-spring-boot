package com.tuana9a.service;

import com.tuana9a.entities.User;

public interface SocialService {
    String createAuthorizationURL();
            
    String createAccessToken(String code) throws Exception;
            
    User getUserInfoByToken(String token) throws Exception;
}
