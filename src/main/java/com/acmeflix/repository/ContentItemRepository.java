package com.acmeflix.repository;

import com.acmeflix.domain.ContentItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository

public interface ContentItemRepository extends JpaRepository<ContentItem,Long> {

    ContentItem findByTitle(String title);

    Set<ContentItem> findTop10ByOrderByRatingDesc();

    Set<ContentItem> findTop10ByOrderByNumberOfViewsDesc();
}
