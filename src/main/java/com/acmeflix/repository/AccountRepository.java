package com.acmeflix.repository;

import com.acmeflix.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account,Long> {

    @Query(value = "select p2.name, p2.TOTAL_WATCH_TIME from accounts p1 inner join profiles P2 on p1.ID = P2.ACCOUNT_ID where p1.ID = :#{#id}", nativeQuery = true)
    List<Object[]> findViewingHoursPerProfileByAccountID(Long id);

}
