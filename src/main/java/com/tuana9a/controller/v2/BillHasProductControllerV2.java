package com.tuana9a.controller.v2;

import com.tuana9a.entities.data.Bill;
import com.tuana9a.entities.data.BillHasProduct;
import com.tuana9a.entities.data.Customer;
import com.tuana9a.entities.data.Product;
import com.tuana9a.entities.key.BillHasProductKey;
import com.tuana9a.repository.v2.BillHasProductRepoV2;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/public/bills-has-products")

@AllArgsConstructor
public class BillHasProductControllerV2 {

    private final BillHasProductRepoV2 repo;


    @PostMapping("/")
    public void save(@RequestBody BillHasProduct billHasProduct, @RequestHeader("token") Object o) {
        BillHasProductKey key = BillHasProductKey.builder()
                .billId(1)
                .productId(1)
                .build();
        billHasProduct.setKey(key);

        repo.save(billHasProduct);
    }

    @GetMapping("/")
    public Optional<BillHasProduct> findById(@RequestParam("billId") Integer billId, @RequestParam("productId") Integer productId) {
        return repo.findById(new BillHasProductKey(billId, productId));
    }


    @GetMapping("/bill/{id}")
    public List<BillHasProduct> findByBillId(@PathVariable("id") Integer id) {
        BillHasProduct key = BillHasProduct.builder()
                .key(BillHasProductKey.builder()
                        .billId(id)
                        .build())
                .build();
        Example<BillHasProduct> example = Example.of(key);
        return repo.findAll(example);
    }

    @GetMapping("/bill/customer/name")
    public List<BillHasProduct> findByBillCustomerName(@RequestParam("customerName") String name) {
        BillHasProduct key = BillHasProduct.builder()
                .bill(Bill.builder()
                        .customer(Customer.builder()
                                .name(name)
                                .build())
                        .build())
                .build();

        ExampleMatcher mather = ExampleMatcher.matchingAll()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<BillHasProduct> example = Example.of(key, mather);
        return repo.findAll(example);
    }

    @GetMapping("/bill/customer/{id}")
    public List<BillHasProduct> findByBillCustomerId(@PathVariable("id") Integer id) {
        BillHasProduct key = BillHasProduct.builder()
                .bill(Bill.builder()
                        .customer(Customer.builder()
                                .id(id)
                                .build())
                        .build())
                .build();
        Example<BillHasProduct> example = Example.of(key);
        return repo.findAll(example);
    }


    @GetMapping("/product/{id}")
    public List<BillHasProduct> findByProductId(@PathVariable("id") Integer id) {
        BillHasProduct key = BillHasProduct.builder()
                .key(BillHasProductKey.builder()
                        .productId(id)
                        .build())
                .build();
        Example<BillHasProduct> example = Example.of(key);
        return repo.findAll(example);
    }

    @GetMapping("/product/name")
    public List<BillHasProduct> findByBillProductName(@RequestParam("productName") String name) {
        BillHasProduct key = BillHasProduct.builder()
                .product(Product.builder()
                        .name(name)
                        .build())
                .build();

        ExampleMatcher mather = ExampleMatcher.matchingAll()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<BillHasProduct> example = Example.of(key, mather);
        return repo.findAll(example);
    }
}