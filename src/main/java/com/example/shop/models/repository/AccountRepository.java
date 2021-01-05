package com.example.shop.models.repository;


import com.example.shop.models.entity.Account;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AccountRepository extends PagingAndSortingRepository<Account, Long>  {

    boolean existsByEmail(String email);
}
