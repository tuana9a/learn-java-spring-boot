package com.tuana9a.learnjavaspringboot.repository.v5;

import com.tuana9a.learnjavaspringboot.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepo5 extends JpaRepository<Brand, Integer>, JpaSpecificationExecutor<Brand> {
}
