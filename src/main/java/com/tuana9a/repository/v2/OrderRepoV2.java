package com.tuana9a.repository.v2;

import com.tuana9a.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepoV2 extends JpaRepository<Order, Long> {
}
