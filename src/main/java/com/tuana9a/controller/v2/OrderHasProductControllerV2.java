package com.tuana9a.controller.v2;

import com.tuana9a.entities.Order;
import com.tuana9a.entities.OrderHasProduct;
import com.tuana9a.entities.Product;
import com.tuana9a.entities.User;
import com.tuana9a.entities.OrderHasProductKey;
import com.tuana9a.repository.v2.OrderHasProductRepoV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/learn/order-has-product")
public class OrderHasProductControllerV2 {

    @Autowired
    private OrderHasProductRepoV2 repo;

    @PostMapping("/save-random")
    public void save(@RequestBody OrderHasProduct orderHasProduct) {
        OrderHasProductKey key = OrderHasProductKey.builder()
                .orderId(System.currentTimeMillis())
                .productId(System.currentTimeMillis())
                .build();
        orderHasProduct.setKey(key);
        repo.save(orderHasProduct);
    }

    @GetMapping("/")
    public Optional<OrderHasProduct> findById(
            @RequestParam("orderId") Long orderId, @RequestParam("productId") Long productId) {
        return repo.findById(new OrderHasProductKey(orderId, productId));
    }


    @GetMapping("/bill/{id}")
    public List<OrderHasProduct> findByBillId(@PathVariable("id") Long id) {
        OrderHasProduct key = OrderHasProduct.builder()
                .key(OrderHasProductKey.builder()
                        .orderId(id)
                        .build())
                .build();
        Example<OrderHasProduct> example = Example.of(key);
        return repo.findAll(example);
    }

    @GetMapping("/bill/customer/name")
    public List<OrderHasProduct> findByBillCustomerName(@RequestParam("customerName") String name) {
        OrderHasProduct key = OrderHasProduct.builder()
                .order(Order.builder()
                        .user(User.builder()
                                .name(name)
                                .build())
                        .build())
                .build();

        ExampleMatcher mather = ExampleMatcher.matchingAll()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<OrderHasProduct> example = Example.of(key, mather);
        return repo.findAll(example);
    }

    @GetMapping("/bill/customer/{id}")
    public List<OrderHasProduct> findByBillCustomerId(@PathVariable("id") Long id) {
        OrderHasProduct key = OrderHasProduct.builder()
                .order(Order.builder()
                        .user(User.builder()
                                .id(id)
                                .build())
                        .build())
                .build();
        Example<OrderHasProduct> example = Example.of(key);
        return repo.findAll(example);
    }


    @GetMapping("/product/{id}")
    public List<OrderHasProduct> findByProductId(@PathVariable("id") Long id) {
        OrderHasProduct key = OrderHasProduct.builder()
                .key(OrderHasProductKey.builder()
                        .productId(id)
                        .build())
                .build();
        Example<OrderHasProduct> example = Example.of(key);
        return repo.findAll(example);
    }

    @GetMapping("/product/name")
    public List<OrderHasProduct> findByBillProductName(@RequestParam("productName") String name) {
        OrderHasProduct key = OrderHasProduct.builder()
                .product(Product.builder()
                        .name(name)
                        .build())
                .build();

        ExampleMatcher mather = ExampleMatcher.matchingAll()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<OrderHasProduct> example = Example.of(key, mather);
        return repo.findAll(example);
    }
}