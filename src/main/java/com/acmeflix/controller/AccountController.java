package com.acmeflix.controller;

import com.acmeflix.domain.Account;
import com.acmeflix.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("accounts")
public class AccountController {

    private final AccountService accountService;

    @GetMapping()
    public ResponseEntity<List<Account>> findAll(){
        return ResponseEntity.ok(accountService.findAll());
    }

    @PostMapping
    public ResponseEntity<Account> create(@Valid @RequestBody Account account){
        return new ResponseEntity<>(accountService.create(account), HttpStatus.CREATED);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody Account account){
        accountService.update(account);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id){
        accountService.deleteById(id);
    }

    @GetMapping("{id}/searchViewingHours")
    public ResponseEntity<Map<String,Integer>> findViewingHours(@PathVariable Long id){
        return ResponseEntity.ok(accountService.searchViewingHoursPerProfileByAccountID(id));
    }



}
