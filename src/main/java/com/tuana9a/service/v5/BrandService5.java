package com.tuana9a.service.v5;

import com.tuana9a.entities.Brand;
import com.tuana9a.repository.v5.BrandRepo5;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class BrandService5 extends BaseService5<Brand> {
    public BrandService5(BrandRepo5 repo, EntityManager entityManager) {
        super(repo, Brand.class, entityManager);
    }
}
