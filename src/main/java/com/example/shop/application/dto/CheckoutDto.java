package com.example.shop.application.dto;

import lombok.Data;

import java.util.List;

@Data
public class CheckoutDto {
    private List<Long> productsId;
    private Long accountId;
}
