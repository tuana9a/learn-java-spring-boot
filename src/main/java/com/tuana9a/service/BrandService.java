package com.tuana9a.service;

import com.tuana9a.entities.data.Brand;
import com.tuana9a.repository.BrandRepo;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class BrandService extends BaseService<Brand> {
    public BrandService(BrandRepo repo, EntityManager entityManager) {
        super(repo, Brand.class, entityManager);
    }
}
