package com.tuana9a.controllers;

import com.tuana9a.entities.User;
import com.tuana9a.repository.v3.UserRepoV3;
import com.tuana9a.service.GoogleService;
import com.tuana9a.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class OAuthGoogleController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private GoogleService googleService;

    @Autowired
    private UserRepoV3 userRepo;

    @GetMapping("/google/login")
    public String login() {
        return "redirect:" + googleService.createAuthorizationURL();
    }

    @GetMapping("/google/callback")
    public ResponseEntity<Object> callback(@RequestParam(name = "code") String code) throws Exception {
        String accessToken = googleService.createAccessToken(code);
        User googleUser = googleService.getUserInfoByToken(accessToken);
        User existUser = userRepo.findByUsernameAndDeletedFalse(googleUser.getUsername());
        User result;
        if (existUser != null) {
            existUser.setGoogleId(googleUser.getGoogleId());
            existUser.setName(googleUser.getName());
            result = userRepo.save(existUser);
        } else {
            googleUser.setId(System.currentTimeMillis());
            result = userRepo.save(googleUser);
        }
        return ResponseEntity.ok(result);
    }

}
