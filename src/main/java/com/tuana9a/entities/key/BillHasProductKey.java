package com.tuana9a.entities.key;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BillHasProductKey implements Serializable {
    @Column(name = "bill_id")
    private Integer billId;

    @Column(name = "product_id")
    private Integer productId;
}
