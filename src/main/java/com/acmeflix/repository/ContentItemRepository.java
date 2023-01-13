package com.acmeflix.repository;

import com.acmeflix.domain.ContentItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ContentItemRepository extends JpaRepository<ContentItem,Long> {

    ContentItem findByTitle(String title);

    Set<ContentItem> findTop10ByOrderByRatingDesc();

    Set<ContentItem> findTop10ByOrderByNumberOfViewsDesc();

}
