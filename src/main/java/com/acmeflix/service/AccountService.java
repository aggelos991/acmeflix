package com.acmeflix.service;

import com.acmeflix.domain.Account;
import com.acmeflix.domain.Profile;

import java.util.List;
import java.util.Map;

public interface AccountService extends BaseService<Account,Long> {

    List<Object[]> searchViewingHoursPerProfileByAccountID(Long id);

}
