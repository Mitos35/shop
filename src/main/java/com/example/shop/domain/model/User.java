package com.example.shop.domain.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class User {

    private Long id;
    private String name;
    private String email;
    private BigDecimal balance;
}
