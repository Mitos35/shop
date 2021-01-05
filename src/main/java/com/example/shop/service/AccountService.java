package com.example.shop.service;

import com.example.shop.models.entity.Account;

public interface AccountService {
    Long createUser(Account account);
    Long addMoney(Long id, Account account);

}
