package com.acmeflix.repository;

import com.acmeflix.domain.Account;
import com.acmeflix.domain.ContentItem;
import com.acmeflix.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfileRepository extends JpaRepository<Profile,Long> {

    List<Profile> findAllByAccount(Account account);
}
