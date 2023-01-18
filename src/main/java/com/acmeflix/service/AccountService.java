package com.acmeflix.service;

import com.acmeflix.domain.Account;

import java.util.List;

public interface AccountService extends BaseService<Account,Long> {

    List<Object[]> searchViewingHoursPerProfileByAccountID(Long id);

    List<Object[]> searchMoviesWatchedPerProfileByAccountId(Long id);

    List<Object[]> searchTvShowsWatchedPerProfileByAccountId(Long id);

}
