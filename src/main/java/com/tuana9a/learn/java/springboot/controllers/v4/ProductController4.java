package com.tuana9a.learn.java.springboot.controllers.v4;

import com.tuana9a.learn.java.springboot.entities.Product;
import com.tuana9a.learn.java.springboot.repository.v4.ProductRepo4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v4/products")
public class ProductController4 {

    @Autowired
    private ProductRepo4 repo;

    @GetMapping
    public List<Product> findAllSortByPrice(@RequestParam("desc") Boolean desc) {
        return repo.findAllPriceSort(desc);
    }
}
