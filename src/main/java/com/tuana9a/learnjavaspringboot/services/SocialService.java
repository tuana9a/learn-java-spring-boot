package com.tuana9a.learnjavaspringboot.services;

import com.tuana9a.learnjavaspringboot.entities.User;

public interface SocialService {
    String createAuthorizationURL();
            
    String createAccessToken(String code) throws Exception;
            
    User getUserInfoByToken(String token) throws Exception;
}
