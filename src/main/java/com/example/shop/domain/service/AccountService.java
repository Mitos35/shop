package com.example.shop.domain.service;

import com.example.shop.database.entity.Account;
import com.example.shop.database.entity.Product;
import com.example.shop.database.repository.AccountRepository;
import com.example.shop.domain.model.User;
import com.example.shop.mapper.AccountMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public AccountService(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    public Long createUser(User user) {
        Account account = accountMapper.toAccount(user);
        String email = account.getEmail();
        if (accountRepository.existsByEmail(email)) throw new IllegalStateException("ОШИБКА!");

        accountRepository.save(account);
        return account.getId();
    }
}
