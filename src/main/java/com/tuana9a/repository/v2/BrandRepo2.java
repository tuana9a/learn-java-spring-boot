package com.tuana9a.repository.v2;

import com.tuana9a.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepo2 extends JpaRepository<Brand, Integer> {

}