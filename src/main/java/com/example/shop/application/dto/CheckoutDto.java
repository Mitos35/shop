package com.example.shop.application.dto;

import com.example.shop.models.entity.Product;
import lombok.Data;

import java.util.List;

@Data
public class CheckoutDto {
    private List<Product> products;
    private Long accountId;
}
