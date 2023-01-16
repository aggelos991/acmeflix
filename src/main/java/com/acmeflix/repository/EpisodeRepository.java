package com.acmeflix.repository;

import com.acmeflix.domain.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EpisodeRepository extends JpaRepository<Episode,Long> {

    List<Episode> findByTitleContainsIgnoreCase(String title);

}
