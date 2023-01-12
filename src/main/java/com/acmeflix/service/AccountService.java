package com.acmeflix.service;

import com.acmeflix.domain.Account;

public interface AccountService extends BaseService<Account,Long> {

    Account searchByEmail(String email);
}
