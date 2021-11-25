package com.tuana9a.repository;

import com.tuana9a.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BrandRepo extends JpaRepository<Brand,Integer>, JpaSpecificationExecutor<Brand> {
}
