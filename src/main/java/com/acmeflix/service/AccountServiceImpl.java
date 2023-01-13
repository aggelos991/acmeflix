package com.acmeflix.service;

import com.acmeflix.domain.Account;
import com.acmeflix.repository.AccountRepository;
import jdk.jfr.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService{

    private final AccountRepository accountRepository;

    @Override
    JpaRepository<Account,Long> getRepository(){
        return accountRepository;
    }

}
