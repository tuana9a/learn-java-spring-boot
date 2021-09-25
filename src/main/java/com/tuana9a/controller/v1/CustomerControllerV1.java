package com.tuana9a.controller.v1;

import com.tuana9a.entities.data.Customer;
import com.tuana9a.repository.v1.CustomerRepoV1;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/public/customers")
@AllArgsConstructor
public class CustomerControllerV1 {

    private final CustomerRepoV1 repo;

    @PostMapping("/")
    public void persist(@RequestBody Customer customer) {
        repo.persist(customer);
    }

    @GetMapping("/{id}")
    public Customer queryById(@PathVariable("id") int id) {
        return repo.findById(id);
    }

    @PutMapping("/{id}")
    public void merge(@RequestBody Customer customer) {
        repo.merge(customer);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") int id) {
        repo.remove(id);
    }

}
