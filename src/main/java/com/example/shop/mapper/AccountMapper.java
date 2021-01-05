package com.example.shop.mapper;

import com.example.shop.application.dto.AccountDto;
import com.example.shop.models.entity.Account;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class AccountMapper {

    private final ModelMapper mapper;

    public AccountMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Account toModel(AccountDto accountDto) {
        return Objects.isNull(accountDto) ? null : mapper.map(accountDto, Account.class);
    }
}
