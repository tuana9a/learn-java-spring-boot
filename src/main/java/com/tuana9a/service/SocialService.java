package com.tuana9a.service;

import com.tuana9a.entities.data.AppUser;

public interface SocialService {
    String createAuthorizationURL();
            
    String createAccessToken(String code) throws Exception;
            
    AppUser getUserInfoByToken(String token) throws Exception;
}
