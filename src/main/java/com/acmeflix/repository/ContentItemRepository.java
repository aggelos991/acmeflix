package com.acmeflix.repository;

import com.acmeflix.domain.ContentItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface ContentItemRepository extends JpaRepository<ContentItem,Long> {

    List<ContentItem> findByTitleContainsIgnoreCase(String title);

    Set<ContentItem> findAllByReleaseYear(Integer year);

    Set<ContentItem> findAllByPersonsFirstNameContainsIgnoreCaseAndPersonsLastNameContainsIgnoreCase(String firstName,String lastName);

    Set<ContentItem> findAllByCategoryNameIgnoreCase(String categoryName);

    List<ContentItem> findTop10ByOrderByRatingDesc();

    List<ContentItem> findTop10ByOrderByNumberOfViewsDesc();

}
