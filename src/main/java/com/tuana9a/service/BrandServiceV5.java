package com.tuana9a.service;

import com.tuana9a.entities.Brand;
import com.tuana9a.repository.v5.BrandRepoV5;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class BrandServiceV5 extends BaseService<Brand> {
    public BrandServiceV5(BrandRepoV5 repo, EntityManager entityManager) {
        super(repo, Brand.class, entityManager);
    }
}
