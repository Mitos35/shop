package com.example.shop.service.impl;

import com.example.shop.application.dto.CheckoutDto;
import com.example.shop.models.entity.Account;
import com.example.shop.models.repository.AccountRepository;
import com.example.shop.service.ProductService;
import com.example.shop.models.entity.Product;
import com.example.shop.models.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final AccountRepository accountRepository;

    public ProductServiceImpl(ProductRepository productRepository, AccountRepository accountRepository) {
        this.productRepository = productRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return StreamSupport.stream(productRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public String pay(CheckoutDto checkoutDto) {
        BigDecimal totalPrice = new BigDecimal(0);
        for (int i = 0; i < checkoutDto.getProducts().size(); i++) {
            totalPrice = totalPrice.add(
                    productRepository.findById(checkoutDto.getProducts().get(i).getId())
                            .get().getPrice()
            );
        }

//        BigDecimal userBalance = new BigDecimal(String.valueOf(accountRepository.findById(account.getId())));
//
//        if (userBalance.compareTo(userBalance) >= 0){
//
//        }

        return null;
    }
}
