package com.example.shop.mapper;

import com.example.shop.application.dto.AccountDto;
import com.example.shop.database.entity.Account;
import com.example.shop.domain.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class AccountMapper {

    private final ModelMapper mapper;

    public AccountMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public User toModel(AccountDto accountDto) {
        return Objects.isNull(accountDto) ? null : mapper.map(accountDto, User.class);
    }

    public Account toAccount(User user) {
        return Objects.isNull(user) ? null :mapper.map(user, Account.class);
    }
}
