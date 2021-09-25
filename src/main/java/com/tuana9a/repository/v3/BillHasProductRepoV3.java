package com.tuana9a.repository.v3;

import com.tuana9a.entities.data.BillHasProduct;
import com.tuana9a.entities.key.BillHasProductKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillHasProductRepoV3 extends JpaRepository<BillHasProduct, BillHasProductKey> {

    List<BillHasProduct> findByKey_ProductId(Integer id);

    List<BillHasProduct> findByProduct_NameContains(String name);

    List<BillHasProduct> findByBill_Id(Integer id);

    List<BillHasProduct> findByBill_Customer_Id(Integer id);

    List<BillHasProduct> findByBill_Customer_NameContains(String name);

}
