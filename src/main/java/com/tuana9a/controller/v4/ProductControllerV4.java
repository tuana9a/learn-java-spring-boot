package com.tuana9a.controller.v4;

import com.tuana9a.entities.data.Product;
import com.tuana9a.repository.v4.ProductRepoV4;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v4/public/products")

@AllArgsConstructor
public class ProductControllerV4 {
    private final ProductRepoV4 repo;

    @GetMapping("/")
    public List<Product> findAllSortByPrice(@RequestParam("desc") Boolean desc) {
        return repo.findAllPriceSort(desc);
    }
}
