package com.tuana9a.entities.data;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import javax.persistence.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "image")
    private String image;

    @Column(name = "introduction")
    private String introduction;

    @Column(name = "created")
    private Long created;

    @Column(name = "deleted")
    private Boolean deleted;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "bill_has_product",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "bill_id"))
    @JsonSerialize(using = Bill.ListSerializer.class)
    private List<Bill> bills;


    public static class SingleSerializer extends JsonSerializer<Product> {
        @Override
        public void serialize(Product product, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeObject(ShortenJson.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .price(product.getPrice())
                    .quantity(product.getQuantity())
                    .image(product.getImage())
                    .introduction(product.getIntroduction())
                    .created(product.getCreated())
                    .deleted(product.getDeleted())

                    .brand(product.getBrand())
                    .category(product.getCategory())

                    .build());
        }

    }

    public static class ListSerializer extends JsonSerializer<List<Product>> {
        @Override
        public void serialize(List<Product> products, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            List<ShortenJson> result = new ArrayList<>();
            products.forEach(product -> result.add(ShortenJson.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .price(product.getPrice())
                    .quantity(product.getQuantity())
                    .image(product.getImage())
                    .introduction(product.getIntroduction())
                    .created(product.getCreated())
                    .deleted(product.getDeleted())
                    .brand(product.getBrand())
                    .category(product.getCategory())

                    //                .bills(product.getBills())//EXPLAIN: cho vô là loop

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

        private String name;

        private Double price;

        private Integer quantity;

        private String image;

        private String introduction;

        private Long created;

        private Boolean deleted;

        private Brand brand;

        private Category category;
    }
}
