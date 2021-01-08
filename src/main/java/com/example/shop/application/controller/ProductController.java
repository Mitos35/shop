package com.example.shop.application.controller;

import com.example.shop.application.dto.CheckoutDto;
import com.example.shop.application.dto.ProductDto;
import com.example.shop.application.facade.ProductFacade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductFacade productFacade;

    public ProductController(ProductFacade productFacade) {
        this.productFacade = productFacade;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDto> getAllProducts(@RequestParam(required = false) String category) {
        return productFacade.getAllProducts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public String pay(CheckoutDto checkoutDto) {
        return productFacade.pay(checkoutDto);
    }
}
