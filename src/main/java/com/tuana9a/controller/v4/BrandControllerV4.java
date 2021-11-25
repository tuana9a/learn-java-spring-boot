package com.tuana9a.controller.v4;

import com.tuana9a.entities.Brand;
import com.tuana9a.repository.v4.BrandRepoV4;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v4/public/brands")

@AllArgsConstructor
public class BrandControllerV4 {

    private final BrandRepoV4 repo;

    @GetMapping("/")
    public List<Brand> findAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Brand findById(@PathVariable("id") Integer id) {
        return repo.findById(id);
    }
}
