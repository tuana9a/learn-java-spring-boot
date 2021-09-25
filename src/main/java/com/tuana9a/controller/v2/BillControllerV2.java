package com.tuana9a.controller.v2;

import com.tuana9a.entities.data.Bill;
import com.tuana9a.repository.v2.BillRepoV2;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/public/bills")

@AllArgsConstructor
public class BillControllerV2 {

    private final BillRepoV2 repo;

    @PostMapping("/")
    public void save(@RequestBody Bill bill) {
        repo.save(bill);
    }

    @GetMapping("/")
    public List<Bill> findAll() {
        return repo.findAll();
    }

    @GetMapping("/asc")
    public List<Bill> findAllTotalMoneyDesc() {
        Sort totalMoneyDesc = Sort.by(Sort.Direction.DESC, "totalMoney");
        return repo.findAll(totalMoneyDesc);
    }

    @GetMapping("/page")
    public Page<Bill> findAllPage(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @GetMapping("/page/{page}")
    public Page<Bill> finAllPage(@PathVariable("page") Integer page) {
        Sort sort = Sort.by("totalMoney");
        Pageable pageable = PageRequest.of(page, 10, sort);
        Example<Bill> deletedFalse = Example.of(Bill.builder().deleted(false).build());
        return repo.findAll(deletedFalse, pageable);
    }

    @GetMapping("/{id}")
    public Optional<Bill> findById(@PathVariable("id") Integer id) {
        return repo.findById(id);
    }
}
