package com.tuana9a.learn.java.springboot.controllers.v3;

import com.tuana9a.learn.java.springboot.entities.Brand;
import com.tuana9a.learn.java.springboot.repository.v3.BrandRepo3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v3/brands")
public class BrandController3 {

    @Autowired
    private BrandRepo3 repo;

    @GetMapping
    public List<Brand> findByIds(@RequestParam("ids") List<Integer> ids) {
        return repo.findByIdInAndDeletedFalse(ids);
    }

    @GetMapping("/existByName")
    public Boolean existByName(@RequestParam("name") String name) {
        return repo.existsBrandByNameContains(name);
    }
}
