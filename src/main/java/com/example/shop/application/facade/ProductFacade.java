package com.example.shop.application.facade;

import com.example.shop.application.dto.ProductDto;
import com.example.shop.mapper.ProductMapper;
import com.example.shop.service.ProductService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductFacade {

    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductFacade(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts().stream()
                .map(productMapper::toDo)
                .collect(Collectors.toList());
    }

}
