package com.acmeflix.repository;

import com.acmeflix.domain.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SeasonRepository extends JpaRepository<Season,Long> {

    Season findByTitle(String title);
}
