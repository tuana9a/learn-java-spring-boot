package com.tuana9a.controller;

import com.tuana9a.service.GoogleService;
import com.tuana9a.service.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller

@AllArgsConstructor
public class SocialController {

    private final JwtService jwtService;
    private final GoogleService googleService;

    @GetMapping("/login-google")
    public String loginGoogle() {
        return "redirect:" + googleService.createAuthorizationURL();
    }

    @GetMapping("/login-google/callback")
    public ResponseEntity<Object> googleCallBack(@RequestParam(name = "code") String code) {
        try {
            String accessToken = googleService.createAccessToken(code);
            return ResponseEntity.ok(googleService.getUser(accessToken));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(e);
        }
    }

}
