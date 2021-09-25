package com.tuana9a.controller.v3;

import com.tuana9a.entities.data.Brand;
import com.tuana9a.repository.v3.BrandRepoV3;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v3/public/brands")

@AllArgsConstructor
public class BrandControllerV3 {
    private final BrandRepoV3 repo;

    @GetMapping("/")
    public List<Brand> findByIds(@RequestParam("ids") List<Integer> ids) {
        return repo.findByIdInAndDeletedFalse(ids);
    }

    @GetMapping("/exist/name")
    public Boolean existByName(@RequestParam("name") String name) {
        return repo.existsBrandByNameContains(name);
    }
}
