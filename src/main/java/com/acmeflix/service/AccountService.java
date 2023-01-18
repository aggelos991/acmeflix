package com.acmeflix.service;

import com.acmeflix.domain.Account;

import java.util.Map;

public interface AccountService extends BaseService<Account,Long> {

    Map<String,Integer> searchViewingHoursPerProfileByAccountID(Long id);

}
