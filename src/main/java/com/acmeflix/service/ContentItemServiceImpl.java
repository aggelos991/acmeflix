package com.acmeflix.service;

import com.acmeflix.domain.ContentItem;
import com.acmeflix.repository.ContentItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ContentItemServiceImpl extends BaseServiceImpl<ContentItem> implements ContentItemService {

    private final ContentItemRepository contentItemRepository;

    @Override
    JpaRepository<ContentItem, Long> getRepository() {
        return contentItemRepository;
    }

    @Override
    public ContentItem searchByTitle(final String title){
        return Optional.ofNullable(contentItemRepository.findByTitle(title)).orElseThrow(
                NoSuchElementException::new);
    }

    @Override
    public Set<ContentItem> searchTop10ByNumberOfViews(){
        return contentItemRepository.findTop10ByOrderByNumberOfViewsDesc();
    }

    @Override
    public Set<ContentItem> searchTop10ByRating(){
        return contentItemRepository.findTop10ByOrderByRatingDesc();
    }


}
