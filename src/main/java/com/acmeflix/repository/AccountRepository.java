package com.acmeflix.repository;

import com.acmeflix.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account,Long> {

    @Query(value = "select p2.name, p2.TOTAL_WATCH_TIME from accounts p1 " +
            "inner join profiles P2 on p1.ID = P2.ACCOUNT_ID " +
            "where p1.ID = :#{#id}"
            , nativeQuery = true)
    List<Object[]> findViewingHoursPerProfileByAccountID(Long id);

    @Query(value = "select p2.name, M.TITLE from accounts p1 " +
            "inner join PROFILES P2 on p1.ID = P2.ACCOUNT_ID " +
            "inner join PROFILE_CONTENT_ITEMS PCI on P2.ID = PCI.PROFILE_ID " +
            "inner join MOVIES M on PCI.CONTENT_ITEM_ID = M.ID where p1.ID = :#{#id}"
            , nativeQuery = true)
    List<Object[]> findMoviesWatchedPerProfileByAccountId(Long id);

    @Query(value = "select p2.name, T.TITLE from accounts p1 " +
            "inner join PROFILES P2 on p1.ID = P2.ACCOUNT_ID " +
            "inner join PROFILE_CONTENT_ITEMS PCI on P2.ID = PCI.PROFILE_ID " +
            "inner join TV_SHOWS T on PCI.CONTENT_ITEM_ID = T.ID " +
            "where p1.ID = :#{#id}"
            , nativeQuery = true)
    List<Object[]> findTvShowsWatchedPerProfileByAccountId(Long id);
}
