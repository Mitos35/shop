package com.example.shop.service.impl;

import com.example.shop.models.entity.Account;
import com.example.shop.models.repository.AccountRepository;
import com.example.shop.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Long createUser(Account account) {
        String email = account.getEmail();
        if (accountRepository.existsByEmail(email))
            throw new IllegalStateException("Error such mail is already!");

        accountRepository.save(account);
        return account.getId();
    }

    @Override
    public Long addMoney(Long id, Account account) {
        if (!accountRepository.existsById(id)) throw new IllegalStateException("User does not exist");
        account.setId(id);
        accountRepository.save(account);
        return account.getId();
    }
}
