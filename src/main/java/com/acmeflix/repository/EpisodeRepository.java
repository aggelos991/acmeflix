package com.acmeflix.repository;

import com.acmeflix.domain.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode,Long> {

    Episode findByTitle(String title);
}
