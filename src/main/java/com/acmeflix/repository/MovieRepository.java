package com.acmeflix.repository;

import com.acmeflix.domain.Category;
import com.acmeflix.domain.Movie;
import com.acmeflix.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface MovieRepository extends JpaRepository<Movie,Long> {

    List<Movie> findByTitleContainsIgnoreCase(String title);

    Set<Movie> findAllByReleaseYear(Integer year);

    Set<Movie> findAllByPersonsFirstNameContainsIgnoreCaseAndPersonsLastNameContainsIgnoreCase(String firstName,String lastName);

    Set<Movie> findAllByCategoryNameIgnoreCase(String categoryName);

    List<Movie> findTop10ByOrderByRatingDesc();

    List<Movie> findTop10ByOrderByNumberOfViewsDesc();

    @Query(value = "select C.NAME from MOVIES inner join CATEGORIES C on C.ID = MOVIES.CATEGORY_ID group by C.NAME order by count(CATEGORY_ID) desc limit 5", nativeQuery = true)
    List<Category> findTop5PopularCategories();
}
