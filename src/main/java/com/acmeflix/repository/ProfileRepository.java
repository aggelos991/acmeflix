package com.acmeflix.repository;

import com.acmeflix.domain.Account;
import com.acmeflix.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ProfileRepository extends JpaRepository<Profile,Long> {

}