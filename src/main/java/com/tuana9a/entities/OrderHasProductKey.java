package com.tuana9a.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable

@Getter
@Setter

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderHasProductKey implements Serializable {
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "product_id")
    private Long productId;
}
