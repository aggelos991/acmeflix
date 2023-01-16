package com.acmeflix.repository;

import com.acmeflix.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AccountRepository extends JpaRepository<Account,Long> {

}
