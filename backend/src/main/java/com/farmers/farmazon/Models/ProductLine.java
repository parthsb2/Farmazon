package com.farmers.farmazon.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "productLines")
public class ProductLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private Integer quantity;

    @Column
    private Integer totalPrice;

    @Column
    private Boolean inCart;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties({"cart", "productLines"})
    private User user;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "cart_id")
    private Cart cart;

    public void setTotalPrice(){
        totalPrice = quantity * product.getPrice();
    }

    public String getProductName() {
        return this.product.getName();
    }

    public Integer getProductId() {
        return this.product.getId();
    }

    public Integer getUserId() {
        return this.user.getId();
    }

}
