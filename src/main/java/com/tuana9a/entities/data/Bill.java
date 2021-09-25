package com.tuana9a.entities.data;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bill")

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "created")
    private Long created;

    @Column(name = "total_money")
    private Double totalMoney;

    @Column(name = "deleted")
    private Boolean deleted;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany
    @JoinTable(name = "bill_has_product",
            joinColumns = @JoinColumn(name = "bill_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    @JsonSerialize(using = Product.ListSerializer.class)
    private List<Product> products;


    public static class SingleSerializer extends JsonSerializer<Bill> {
        @Override
        public void serialize(Bill bill, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

            jsonGenerator.writeObject(ShortenJson.builder()
                    .id(bill.getId())
                    .created(bill.getCreated())
                    .totalMoney(bill.getTotalMoney())
                    .deleted(bill.getDeleted())

                    .customer(bill.getCustomer())

                    .build());
        }
    }

    public static class ListSerializer extends JsonSerializer<List<Bill>> {
        @Override
        public void serialize(List<Bill> bills, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            List<ShortenJson> result = new ArrayList<>();
            bills.forEach(bill -> result.add(ShortenJson.builder()
                    .id(bill.getId())
                    .created(bill.getCreated())
                    .totalMoney(bill.getTotalMoney())
                    .deleted(bill.getDeleted())

                    .customer(bill.getCustomer())
                    //                .products(bill.getProducts())//EXPLAIN cho vô là loop

                    .build()));
            jsonGenerator.writeObject(result);
        }

    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ShortenJson {
        private Integer id;
        private Long created;
        private Double totalMoney;
        private Boolean deleted;
        private Customer customer;
    }
}
