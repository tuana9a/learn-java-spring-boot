package com.tuana9a.repository.v1;

import com.tuana9a.entities.data.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;

@Repository
@AllArgsConstructor
public class BrandRepoV1 {

    @PersistenceContext
    private final EntityManager entityManager;

    public Brand findById(Integer id) {
        return entityManager.find(Brand.class, id);
    }

    @Transactional
    public void persist(Brand brand) {
        entityManager.persist(brand);
    }

    @Transactional
    public void merge(Brand brand) {
        entityManager.merge(brand);
    }

    @Transactional
    public void remove(int id) {
        entityManager.remove(entityManager.find(Brand.class, id));
    }

}
