package com.tuana9a.entities;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "brand")

@Getter
@Setter

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Brand {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "deleted")
    private Boolean deleted;
}
