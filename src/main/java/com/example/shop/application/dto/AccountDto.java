package com.example.shop.application.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountDto {
    private Long id;
    private String name;
    private String email;
    private BigDecimal balance;
}
