package com.tuana9a.repository.v3;

import com.tuana9a.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepoV3 extends JpaRepository<User, Integer> {
    boolean existsByUsernameAndDeletedFalse(String username);

    boolean existsByUsernameAndPasswordAndDeletedFalse(String username, String password);

    User findByUsernameAndDeletedFalse(String username);
}
