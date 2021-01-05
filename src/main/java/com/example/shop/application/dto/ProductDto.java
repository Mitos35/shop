package com.example.shop.application.dto;

import com.example.shop.models.entity.Discount;
import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private String nameProduct;
    private Double price;
    private String category;
    private Discount discounts;
}
