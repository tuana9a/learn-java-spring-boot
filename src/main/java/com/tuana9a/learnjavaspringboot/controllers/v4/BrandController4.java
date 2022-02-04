package com.tuana9a.learnjavaspringboot.controllers.v4;

import com.tuana9a.learnjavaspringboot.entities.Brand;
import com.tuana9a.learnjavaspringboot.repository.v4.BrandRepo4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v4/brands")
public class BrandController4 {

    @Autowired
    private BrandRepo4 repo;

    @GetMapping
    public List<Brand> findAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Brand findById(@PathVariable("id") Long id) {
        return repo.findById(id);
    }
}
