package com.example.shop.models.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name = "product")

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="name_product")
    private String nameProduct;
    private BigDecimal price;
    private String category;

    @ManyToOne
    @JoinColumn(name = "discount_id", referencedColumnName ="id")
    private Discount discounts;

}
