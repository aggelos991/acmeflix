package com.acmeflix.controller;

import com.acmeflix.domain.Account;
import com.acmeflix.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("accounts")
    public List<Account> findAll(){
        return accountService.findAll();
    }

}
