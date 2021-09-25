package com.tuana9a.repository.v3;

import com.tuana9a.entities.data.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepoV3 extends JpaRepository<AppUser, Integer> {
    boolean existsByUsernameAndDeletedFalse(String username);

    boolean existsByUsernameAndPasswordAndDeletedFalse(String username, String password);

    AppUser findByUsernameAndDeletedFalse(String username);
}
