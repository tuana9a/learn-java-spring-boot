package com.tuana9a.learn.java.springboot.repository.v3;

import com.tuana9a.learn.java.springboot.entities.Brand;
import com.tuana9a.learn.java.springboot.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo3 extends JpaRepository<Product, Integer> {

    List<Product> findByNameIsLikeAndBrand(String name, Brand brand);

    List<Product> findByNameIsLikeAndBrand_Id(String name, Integer brandId);
}
