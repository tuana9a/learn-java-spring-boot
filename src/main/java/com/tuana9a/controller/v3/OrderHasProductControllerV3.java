package com.tuana9a.controller.v3;

import com.tuana9a.entities.OrderHasProduct;
import com.tuana9a.repository.v3.OrderHasProductRepoV3;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/learn/bills-has-products")

@AllArgsConstructor
public class OrderHasProductControllerV3 {

    private final OrderHasProductRepoV3 repo;

    @GetMapping("/bill/{id}")
    public List<OrderHasProduct> findByBillId(@PathVariable("id") Integer id) {
        return repo.findByOrder_Id(id);
    }

    @GetMapping("/bill/customer/name")
    public List<OrderHasProduct> findByBillCustomerName(@RequestParam("customerName") String name) {
        return repo.findByOrder_User_NameContains(name);
    }

    @GetMapping("/bill/customer/{id}")
    public List<OrderHasProduct> findByBillCustomerId(@PathVariable("id") Integer id) {
        return repo.findByOrder_User_Id(id);
    }

    @GetMapping("/product/{id}")
    public List<OrderHasProduct> findByProductId(@PathVariable("id") Integer id) {
        return repo.findByKey_ProductId(id);
    }

    @GetMapping("/product/name")
    public List<OrderHasProduct> findByBillProductName(@RequestParam("productName") String name) {
        return repo.findByProduct_NameContains(name);
    }

}