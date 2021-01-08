package com.example.shop.application.facade.impl;

import com.example.shop.application.dto.CheckoutDto;
import com.example.shop.application.dto.ProductDto;
import com.example.shop.application.facade.ProductFacade;
import com.example.shop.mapper.ProductMapper;
import com.example.shop.service.ProductService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductFacadeImpl implements ProductFacade {

    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductFacadeImpl(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts().stream()
                .map(productMapper::toDo)
                .collect(Collectors.toList());
    }

    @Override
    public String pay(CheckoutDto checkoutDto) {
        return productService.pay(checkoutDto);
    }
}
