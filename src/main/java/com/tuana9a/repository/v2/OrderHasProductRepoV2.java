package com.tuana9a.repository.v2;

import com.tuana9a.entities.OrderHasProduct;
import com.tuana9a.entities.OrderHasProductKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderHasProductRepoV2 extends JpaRepository<OrderHasProduct, OrderHasProductKey> {

}
