package com.tuana9a.controller.v3;

import com.tuana9a.repository.v3.UserRepoV3;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/admin/users")

@AllArgsConstructor
public class AdminUserController {
    private final UserRepoV3 repo;

    @GetMapping("/")
    public ResponseEntity<Object> findAllUsers() {
        return ResponseEntity.ok(repo.findAll());
    }
}
