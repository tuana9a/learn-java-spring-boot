package com.tuana9a.repository.v3;

import com.tuana9a.entities.data.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepoV3 extends JpaRepository<AppUser, Integer> {
    boolean existsByUsernameAndDeletedFalse(String username);

    boolean existsByUsernameAndPasswordAndDeletedFalse(String username, String password);

    AppUser findByUsernameAndDeletedFalse(String username);
}
