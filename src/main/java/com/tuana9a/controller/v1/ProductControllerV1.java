package com.tuana9a.controller.v1;

import com.tuana9a.entities.Product;
import com.tuana9a.models.CountEntity;
import com.tuana9a.models.CountAnyByAny;
import com.tuana9a.repository.v1.ProductRepoV1;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/public/products")
@AllArgsConstructor
public class ProductControllerV1 {

    private final ProductRepoV1 repo;

    @PostMapping("/")
    public void persist(@RequestBody Product p) {
        repo.persist(p);
    }

    @GetMapping("/")
    public List<Product> findALl() {
        return repo.findAll();
    }


    @GetMapping("/{id}")
    public Product findById(@PathVariable("id") int id) {
        return repo.findById(id);
    }

    @PutMapping("/{id}")
    public void merge(@RequestBody Product address) {
        repo.merge(address);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") int id) {
        repo.remove(id);
    }


    @GetMapping("/count-all")
    public Long countAll() {
        return repo.countAll();
    }

    @GetMapping("/custom-count-all")
    public CountEntity customCountAll() {
        return repo.customCountAll();
    }

    @GetMapping("/count-group-by-brand")
    public List<CountAnyByAny> queryCountProductByBrand() {
        return repo.countGroupByBrand();
    }
}
