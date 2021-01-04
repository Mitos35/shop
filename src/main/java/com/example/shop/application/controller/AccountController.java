package com.example.shop.application.controller;

import com.example.shop.application.dto.AccountDto;
import com.example.shop.application.facade.AccountFacade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountFacade accountFacade;

    public AccountController(AccountFacade accountFacade) {
        this.accountFacade = accountFacade;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long createUser(@RequestBody AccountDto accountDto) {
        return accountFacade.createUser(accountDto);
    }
}
