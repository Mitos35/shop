package com.example.shop.application.facade.impl;

import com.example.shop.application.dto.AccountDto;
import com.example.shop.application.facade.AccountFacade;
import com.example.shop.mapper.AccountMapper;
import com.example.shop.service.AccountService;
import org.springframework.stereotype.Component;

@Component
public class AccountFacadeImpl implements AccountFacade {

    private final AccountService accountService;
    private final AccountMapper accountMapper;

    public AccountFacadeImpl(AccountService userService, AccountMapper accountMapper) {
        this.accountService = userService;
        this.accountMapper = accountMapper;
    }

    @Override
    public Long createUser(AccountDto accountDto) {
        return accountService.createUser(accountMapper.toModel(accountDto));
    }

    @Override
    public Long addMoney(Long id, AccountDto accountDto) {
        return accountService.addMoney(id, accountMapper.toModel(accountDto));
    }
}
