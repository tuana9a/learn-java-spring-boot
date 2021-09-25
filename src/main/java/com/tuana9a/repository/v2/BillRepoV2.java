package com.tuana9a.repository.v2;

import com.tuana9a.entities.data.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepoV2 extends JpaRepository<Bill, Integer> {
}
