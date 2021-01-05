package com.example.shop.application.facade;

import com.example.shop.application.dto.AccountDto;

public interface AccountFacade {
    Long createUser(AccountDto accountDto);
    Long addMoney(Long id, AccountDto accountDto);
}
