package com.acmeflix.service;

import com.acmeflix.domain.ContentItem;

import java.util.List;
import java.util.Set;

public interface ContentItemService extends BaseService<ContentItem,Long>{

    List<ContentItem> searchByTitle(String title);

    Set<ContentItem> searchByReleaseYear(Integer year);

    Set<ContentItem> searchByCategory(String categoryName);

    Set<ContentItem> searchByPersonsName(String firstName, String lastName);


    Set<ContentItem> searchTop10ByNumberOfViews();

    Set<ContentItem> searchTop10ByRating();

}
