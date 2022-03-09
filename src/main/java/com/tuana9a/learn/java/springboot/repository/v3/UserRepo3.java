package com.tuana9a.learn.java.springboot.repository.v3;

import com.tuana9a.learn.java.springboot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo3 extends JpaRepository<User, Integer> {
    boolean existsByUsernameAndDeletedFalse(String username);

    boolean existsByUsernameAndPasswordAndDeletedFalse(String username, String password);

    User findByUsernameAndDeletedFalse(String username);
}
