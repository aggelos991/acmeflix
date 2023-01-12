package com.acmeflix.repository;

import com.acmeflix.domain.Episode;
import com.acmeflix.domain.Season;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodeRepository extends JpaRepository<Episode,Long> {

    Episode findByTitle(String title);
}
