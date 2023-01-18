package com.acmeflix.repository;

import com.acmeflix.domain.Category;
import com.acmeflix.domain.TvShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface TvShowRepository extends JpaRepository<TvShow,Long> {

    List<TvShow> findByTitleContainsIgnoreCase(String title);

    Set<TvShow> findAllByReleaseYear(Integer year);

    Set<TvShow> findAllByPersonsFirstNameContainsIgnoreCaseAndPersonsLastNameContainsIgnoreCase(String firstName,String lastName);

    Set<TvShow> findAllByCategoryNameIgnoreCase(String categoryName);

    List<TvShow> findTop10ByOrderByRatingDesc();

    List<TvShow> findTop10ByOrderByNumberOfViewsDesc();

    @Query(value = "select C.NAME from TV_SHOWS inner join CATEGORIES C on C.ID = TV_SHOWS.CATEGORY_ID group by C.NAME order by count(CATEGORY_ID) desc limit 5", nativeQuery = true)
    List<Category> findTop5PopularCategories();
}
