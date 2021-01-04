package com.example.shop.database.repository;


import com.example.shop.database.entity.Account;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {

    boolean existsByEmail(String email);
}
