package com.tuana9a.controller.v3;

import com.tuana9a.entities.data.BillHasProduct;
import com.tuana9a.repository.v3.BillHasProductRepoV3;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/public/bills-has-products")

@AllArgsConstructor
public class BillHasProductControllerV3 {

    private final BillHasProductRepoV3 repo;

    @GetMapping("/bill/{id}")
    public List<BillHasProduct> findByBillId(@PathVariable("id") Integer id) {
        return repo.findByBill_Id(id);
    }

    @GetMapping("/bill/customer/name")
    public List<BillHasProduct> findByBillCustomerName(@RequestParam("customerName") String name) {
        return repo.findByBill_Customer_NameContains(name);
    }

    @GetMapping("/bill/customer/{id}")
    public List<BillHasProduct> findByBillCustomerId(@PathVariable("id") Integer id) {
        return repo.findByBill_Customer_Id(id);
    }

    @GetMapping("/product/{id}")
    public List<BillHasProduct> findByProductId(@PathVariable("id") Integer id) {
        return repo.findByKey_ProductId(id);
    }

    @GetMapping("/product/name")
    public List<BillHasProduct> findByBillProductName(@RequestParam("productName") String name) {
        return repo.findByProduct_NameContains(name);
    }

}