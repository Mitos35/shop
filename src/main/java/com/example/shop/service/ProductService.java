package com.example.shop.service;

import com.example.shop.application.dto.CheckoutDto;
import com.example.shop.models.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    String pay(CheckoutDto checkoutDto);
}
