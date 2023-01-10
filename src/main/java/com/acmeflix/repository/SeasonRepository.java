package com.acmeflix.repository;

import com.acmeflix.domain.Season;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonRepository extends JpaRepository<Season,Long> {
}
