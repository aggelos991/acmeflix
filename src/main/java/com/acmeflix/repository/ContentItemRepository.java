package com.acmeflix.repository;

import com.acmeflix.domain.ContentItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContentItemRepository extends JpaRepository<ContentItem,Long> {

    @Query(value = "select TITLE,RATING from MOVIES\n" +
            "union all\n" +
            "select TITLE,RATING from TV_SHOWS\n" +
            "order by RATING desc\n" +
            "limit 10",nativeQuery = true)
    List<Object[]> findTop10Rating();

    @Query(value = "select TITLE,NUMBER_OF_VIEWS from MOVIES\n"  +
            "union all\n" +
            "select TITLE,NUMBER_OF_VIEWS from TV_SHOWS\n" +
            "order by NUMBER_OF_VIEWS desc\n" +
            "limit 10",nativeQuery = true)
    List<Object[]> findTop10NumberOfViews();
}
