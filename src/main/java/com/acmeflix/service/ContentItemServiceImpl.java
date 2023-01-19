package com.acmeflix.service;

import com.acmeflix.domain.ContentItem;
import com.acmeflix.domain.Movie;
import com.acmeflix.repository.ContentItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContentItemServiceImpl extends BaseServiceImpl<ContentItem> implements ContentItemService{

    private final ContentItemRepository contentItemRepository;

    @Override
    JpaRepository<ContentItem, Long> getRepository() {
        return contentItemRepository;
    }

    @Override
    public List<Object[]> searchTop10ByNumberOfViews(){
        return contentItemRepository.findTop10NumberOfViews();
    }

    @Override
    public List<Object[]> searchTop10ByRating(){
        return contentItemRepository.findTop10Rating();
    }

}
