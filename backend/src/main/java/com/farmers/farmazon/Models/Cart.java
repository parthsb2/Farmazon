package com.farmers.farmazon.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @OneToMany(mappedBy = "cart", cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JsonIgnoreProperties({"user", "cart", "inCart"})
    private List<ProductLine> productLines;

    @OneToOne(mappedBy = "cart", cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id",
            referencedColumnName = "id")
    @JsonIgnore
    private User user;

}

