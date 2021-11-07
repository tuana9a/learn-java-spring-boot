package com.tuana9a.entities.data;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.util.Objects;

@Entity
@Table(name = "user")

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "google_id")
    private String googleId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "deleted")
    private Boolean deleted;
}
