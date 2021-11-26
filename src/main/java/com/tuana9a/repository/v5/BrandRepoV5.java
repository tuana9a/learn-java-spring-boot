package com.tuana9a.repository.v5;

import com.tuana9a.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BrandRepoV5 extends JpaRepository<Brand,Integer>, JpaSpecificationExecutor<Brand> {
}
