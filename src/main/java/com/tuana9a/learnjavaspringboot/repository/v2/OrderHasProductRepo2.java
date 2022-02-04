package com.tuana9a.learnjavaspringboot.repository.v2;

import com.tuana9a.learnjavaspringboot.entities.OrderHasProduct;
import com.tuana9a.learnjavaspringboot.entities.OrderHasProductKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderHasProductRepo2 extends JpaRepository<OrderHasProduct, OrderHasProductKey> {

}
