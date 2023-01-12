package com.acmeflix.repository;

import com.acmeflix.domain.Account;
import com.acmeflix.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface AccountRepository extends JpaRepository<Account,Long> {

    Account findByEmail(String email);
}
