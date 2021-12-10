package com.tuana9a.controllers.v4;

import com.tuana9a.entities.Brand;
import com.tuana9a.repository.v4.BrandRepoV4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v4/brands")
public class BrandControllerV4 {

    @Autowired
    private BrandRepoV4 repo;

    @GetMapping
    public List<Brand> findAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Brand findById(@PathVariable("id") Long id) {
        return repo.findById(id);
    }
}
