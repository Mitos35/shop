package com.example.shop.service.impl;

import com.example.shop.application.dto.CheckoutDto;
import com.example.shop.models.entity.Account;
import com.example.shop.models.entity.Product;
import com.example.shop.models.repository.AccountRepository;
import com.example.shop.models.repository.ProductRepository;
import com.example.shop.service.ProductService;
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
        String answer = "";

        BigDecimal totalPrice = new BigDecimal("0.0");
        for (int i = 0; i < checkoutDto.getProductsId().size(); i++) {
            totalPrice = totalPrice.add(productRepository.findById(checkoutDto.getProductsId().get(i))
                    .get().getPrice()
            );
        }

        BigDecimal userBalance = accountRepository.findById(checkoutDto.getAccountId()).get().getBalance();

        if (userBalance.compareTo(totalPrice) >= 0) {
            userBalance = userBalance.subtract(totalPrice);
            Account currentUse = accountRepository.findById(checkoutDto.getAccountId()).get();
            currentUse.setBalance(userBalance);
            accountRepository.save(currentUse);
            answer = "Operation completed successfully, your balance " + userBalance;
        } else {
            answer = "There are not enough funds on our balance";
        }
        return answer;
    }
}
