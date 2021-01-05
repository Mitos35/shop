package com.example.shop.application.facade;

import com.example.shop.application.dto.ProductDto;

import java.util.List;

public interface ProductFacade {
    List<ProductDto> getAllProducts();
}
