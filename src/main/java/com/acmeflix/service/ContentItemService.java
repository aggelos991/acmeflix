package com.acmeflix.service;

import com.acmeflix.domain.ContentItem;

import java.util.List;

public interface ContentItemService extends BaseService<ContentItem,Long>{

    List<Object[]> searchTop10ByNumberOfViews();

    List<Object[]> searchTop10ByRating();
}
