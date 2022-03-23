package com.farmers.farmazon.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private String farmName;

    @Column
    private Integer credit = 100;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"user", "cart"})
    private List<ProductLine> productLines;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "cart_id",
            referencedColumnName = "id")
    private Cart cart;

}
