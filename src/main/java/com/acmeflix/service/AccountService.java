package com.acmeflix.service;

import com.acmeflix.domain.Account;

import java.util.List;

public interface AccountService extends BaseService<Account,Long> {

    List<Object[]> searchViewingHoursPerProfileByAccountID(Long id);

}
