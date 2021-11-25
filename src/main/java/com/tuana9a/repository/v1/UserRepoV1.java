package com.tuana9a.repository.v1;

import com.tuana9a.entities.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class UserRepoV1 {

    @PersistenceContext
    private EntityManager entityManager;

    public User find(int id) {
        //EXPLAIN: hàm find tìm theo khóa chính
        return entityManager.find(User.class, id);
    }

    @Transactional
    public void persist(User object) {
        entityManager.persist(object);
    }

    @Transactional
    public void merge(User object) {
        entityManager.merge(object);
    }

    @Transactional
    public void remove(int id) {
        User object = entityManager.find(User.class, id);
        entityManager.remove(object);
    }

}
