package com.tuana9a.controller.v3;

import com.tuana9a.entities.data.AppUser;
import com.tuana9a.entities.form.LoginForm;
import com.tuana9a.entities.form.RegisterForm;
import com.tuana9a.repository.v3.UserRepoV3;
import com.tuana9a.service.JwtService;
import com.tuana9a.utils.EncodeUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v3/public/users")

public class UserControllerV3 {
    @Autowired
    private  UserRepoV3 repo;

    @Autowired
    private  JwtService jwtService;

    @Autowired
    private EncodeUtils encodeUtils;

    @GetMapping("/exist")
    public ResponseEntity<Object> exist(@RequestParam("username") String username) {
        return ResponseEntity.ok()
                .body(repo.existsByUsernameAndDeletedFalse(username));
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginForm form) {
        boolean exist = repo.existsByUsernameAndPasswordAndDeletedFalse(form.getUsername(), encodeUtils.getSHA256(form.getPassword()));
        if (exist) {
            return ResponseEntity.ok(jwtService.generateToken(form.getUsername()));
        }
        return ResponseEntity.noContent()
                .build();
    }

    @PostMapping("/register")
    public boolean register(@RequestBody RegisterForm form) {
        boolean exist = repo.existsByUsernameAndDeletedFalse(form.getUsername());
        if (!exist) {
            AppUser user = AppUser.builder()
                    .username(form.getUsername())
                    .password(encodeUtils.getSHA256(form.getPassword()))
                    .name(form.getName())
                    .deleted(false)
                    .build();
            repo.save(user);
        }
        return !exist;
    }
}
