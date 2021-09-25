package com.tuana9a.repository.v2;

import com.tuana9a.entities.data.BillHasProduct;
import com.tuana9a.entities.key.BillHasProductKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillHasProductRepoV2 extends JpaRepository<BillHasProduct, BillHasProductKey> {

}
