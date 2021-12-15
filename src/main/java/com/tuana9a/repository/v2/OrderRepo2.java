package com.tuana9a.repository.v2;

import com.tuana9a.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo2 extends JpaRepository<Order, Long> {

}
