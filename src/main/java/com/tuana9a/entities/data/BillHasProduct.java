package com.tuana9a.entities.data;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tuana9a.entities.key.BillHasProductKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "bill_has_product")

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BillHasProduct {

    @EmbeddedId
    private BillHasProductKey key;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @MapsId("billId")
    @JoinColumn(name = "bill_id")
    @JsonSerialize(using = Bill.SingleSerializer.class)
    private Bill bill;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    @JsonSerialize(using = Product.SingleSerializer.class)
    private Product product;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "price")
    private Double price;
}
