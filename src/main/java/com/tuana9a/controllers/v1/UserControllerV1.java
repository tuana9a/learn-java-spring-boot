package com.tuana9a.controllers.v1;

import com.tuana9a.entities.User;
import com.tuana9a.models.JsonResponse;
import com.tuana9a.repository.v1.UserRepoV1;
import com.tuana9a.utils.JsonResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserControllerV1 {

    @Autowired
    private UserRepoV1 repo;

    @Autowired
    private JsonResponseUtils responseUtils;

    @PostMapping
    public ResponseEntity<JsonResponse> persist(@RequestBody User object) {
        repo.persist(object);
        return responseUtils.created(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JsonResponse> findById(@PathVariable("id") Integer id) {
        User result = repo.find(id);
        return responseUtils.ok(result);
    }

    @PutMapping
    public ResponseEntity<JsonResponse> merge(@RequestBody User object) {
        repo.merge(object);
        return responseUtils.updated();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<JsonResponse> remove(@PathVariable("id") Integer id) {
        repo.remove(id);
        return responseUtils.deleted();
    }

}
