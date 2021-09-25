package com.tuana9a.repository.v3;

import com.tuana9a.entities.data.Brand;
import com.tuana9a.entities.data.Category;
import com.tuana9a.entities.data.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepoV3 extends JpaRepository<Product, Integer> {

    List<Product> findByNameIsLikeAndBrandAndCategory(String name, Brand brand, Category category);

    List<Product> findByNameIsLikeAndCategory_IdAndBrand_Id(String name, Integer brandId, Integer categoryId);
}
