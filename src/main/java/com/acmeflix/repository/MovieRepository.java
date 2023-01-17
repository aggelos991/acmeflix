package com.acmeflix.repository;

import com.acmeflix.domain.Movie;
import com.acmeflix.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface MovieRepository extends JpaRepository<Movie,Long> {

    List<Movie> findByTitleContainsIgnoreCase(String title);

    Set<Movie> findAllByReleaseYear(Integer year);

    Set<Movie> findAllByPersonsFirstNameContainsIgnoreCaseAndPersonsLastNameContainsIgnoreCase(String firstName,String lastName);

    Set<Movie> findAllByCategoryNameIgnoreCase(String categoryName);

    List<Movie> findTop10ByOrderByRatingDesc();

    List<Movie> findTop10ByOrderByNumberOfViewsDesc();
}
