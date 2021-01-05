package com.example.shop.models.repository;

import com.example.shop.models.entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

}
