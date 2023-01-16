package com.acmeflix.repository;

import com.acmeflix.domain.Season;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeasonRepository extends JpaRepository<Season,Long> {

    List<Season> findByNameContainsIgnoreCase(String name);

}
