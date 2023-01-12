package com.acmeflix.service;

import com.acmeflix.domain.ContentItem;

import java.util.Set;

public interface ContentItemService extends BaseService<ContentItem,Long> {

    ContentItem searchByTitle(String title);

    Set<ContentItem> searchTop10ByNumberOfViews();

    Set<ContentItem> searchTop10ByRating();

}
