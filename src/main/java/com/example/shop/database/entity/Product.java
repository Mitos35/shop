package com.example.shop.database.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    private Double price;
    private String category;

    @ManyToOne
    @JoinColumn(name = "discount_id", referencedColumnName ="id")
    private Discount discounts;

}
