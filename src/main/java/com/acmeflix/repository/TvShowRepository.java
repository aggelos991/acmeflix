package com.acmeflix.repository;

import com.acmeflix.domain.TvShow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface TvShowRepository extends JpaRepository<TvShow,Long> {

    List<TvShow> findByTitleContainsIgnoreCase(String title);

    Set<TvShow> findAllByReleaseYear(Integer year);

    Set<TvShow> findAllByPersonsFirstNameContainsIgnoreCaseAndPersonsLastNameContainsIgnoreCase(String firstName,String lastName);

    Set<TvShow> findAllByCategoryNameIgnoreCase(String categoryName);

    List<TvShow> findTop10ByOrderByRatingDesc();

    List<TvShow> findTop10ByOrderByNumberOfViewsDesc();
}
