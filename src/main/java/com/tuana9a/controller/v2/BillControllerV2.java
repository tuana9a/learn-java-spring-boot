package com.tuana9a.controller.v2;

import com.tuana9a.entities.Order;
import com.tuana9a.repository.v2.OrderRepoV2;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/public/bills")

@AllArgsConstructor
public class BillControllerV2 {

    private final OrderRepoV2 repo;

    @PostMapping("/")
    public void save(@RequestBody Order order) {
        repo.save(order);
    }

    @GetMapping("/")
    public List<Order> findAll() {
        return repo.findAll();
    }

    @GetMapping("/asc")
    public List<Order> findAllTotalMoneyDesc() {
        Sort totalMoneyDesc = Sort.by(Sort.Direction.DESC, "totalMoney");
        return repo.findAll(totalMoneyDesc);
    }

    @GetMapping("/page")
    public Page<Order> findAllPage(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @GetMapping("/page/{page}")
    public Page<Order> finAllPage(@PathVariable("page") Integer page) {
        Sort sort = Sort.by("totalMoney");
        Pageable pageable = PageRequest.of(page, 10, sort);
        Example<Order> deletedFalse = Example.of(Order.builder().deleted(false).build());
        return repo.findAll(deletedFalse, pageable);
    }

    @GetMapping("/{id}")
    public Optional<Order> findById(@PathVariable("id") Integer id) {
        return repo.findById(id);
    }
}
