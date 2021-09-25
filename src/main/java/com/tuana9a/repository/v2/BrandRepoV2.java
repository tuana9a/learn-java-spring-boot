package com.tuana9a.repository.v2;

import com.tuana9a.entities.data.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepoV2 extends JpaRepository<Brand, Integer> {
}
