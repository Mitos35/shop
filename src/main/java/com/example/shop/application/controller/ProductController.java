package com.example.shop.application.controller;

import com.example.shop.application.dto.ProductDto;
import com.example.shop.application.facade.ProductFacade;
import com.example.shop.models.repository.AccountRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductFacade productFacade;
    private final AccountRepository accountRepository;

    public ProductController(ProductFacade productFacade, AccountRepository accountRepository) {
        this.productFacade = productFacade;
        this.accountRepository = accountRepository;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDto> getAllProducts(@RequestParam(required = false) String category) {
        return productFacade.getAllProducts();
    }



}
