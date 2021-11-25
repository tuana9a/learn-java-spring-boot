package com.tuana9a.repository.v3;

import com.tuana9a.entities.Brand;
import com.tuana9a.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepoV3 extends JpaRepository<Product, Integer> {

    List<Product> findByNameIsLikeAndBrand(String name, Brand brand);

    List<Product> findByNameIsLikeAndBrand_Id(String name, Integer brandId);
}
