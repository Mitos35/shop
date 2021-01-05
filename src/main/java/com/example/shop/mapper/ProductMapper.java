package com.example.shop.mapper;

import com.example.shop.application.dto.ProductDto;
import com.example.shop.models.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ProductMapper {

    private final ModelMapper modelMapper;

    public ProductMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ProductDto toDo(Product product) {
        return Objects.isNull(product) ? null : modelMapper.map(product, ProductDto.class);
    }

}
