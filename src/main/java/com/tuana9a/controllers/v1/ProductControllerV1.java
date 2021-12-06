package com.tuana9a.controllers.v1;

import com.tuana9a.entities.Product;
import com.tuana9a.models.CountEntity;
import com.tuana9a.models.CountAnyByAny;
import com.tuana9a.repository.v1.ProductRepoV1;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/products")
public class ProductControllerV1 {

    @Autowired
    private ProductRepoV1 repo;

    @PostMapping
    public void persist(@RequestBody Product object) {
        repo.persist(object);
    }

    @GetMapping
    public Object find(@RequestParam(name = "which") String which) {
        Object result;
        switch (which) {
            case "count-all":
                result = repo.countAll();
                break;
            case "custom-count-all":
                result = repo.customCountAll();
                break;
            case "count-group-by-brand":
                result = repo.countGroupByBrand();
                break;
            default:
                result = repo.findAll();
                break;
        }
        return result;
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable("id") int id) {
        return repo.findById(id);
    }

    @PutMapping("/{id}")
    public void merge(@RequestBody Product object) {
        repo.merge(object);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") int id) {
        repo.remove(id);
    }

}
