package com.tuana9a.controller.v1;

import com.tuana9a.entities.data.Product;
import com.tuana9a.entities.query.CountEntity;
import com.tuana9a.entities.query.CountAnyByAny;
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
    public List<Product> queryAll() {
        return repo.queryAll();
    }


    @GetMapping("/{id}")
    public Product queryById(@PathVariable("id") int id) {
        return repo.queryById(id);
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
    public Long queryCountAll() {
        return repo.queryCountAll();
    }

    @GetMapping("/count-all-custom")
    public CountEntity queryCountAllCustom() {
        return repo.queryCountAllCustom();
    }

    @GetMapping("/count-by-brand")
    public List<CountAnyByAny> queryCountProductByBrand() {
        return repo.queryCountProductByBrand();
    }
}
