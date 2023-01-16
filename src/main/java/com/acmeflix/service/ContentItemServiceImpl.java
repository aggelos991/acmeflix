package com.acmeflix.service;

import com.acmeflix.domain.ContentItem;
import com.acmeflix.repository.ContentItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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
        public List<ContentItem> searchByTitle(final String title){
        return Optional.ofNullable(contentItemRepository.findByTitleContainsIgnoreCase(title)).orElseThrow(
                NoSuchElementException::new);
    }

    @Override
    public Set<ContentItem> searchByReleaseYear(Integer year){
        return contentItemRepository.findAllByReleaseYear(year);
    }

    @Override
    public Set<ContentItem> searchByPersonsName(String firstName, String lastName){
        return contentItemRepository.findAllByPersonsFirstNameContainsIgnoreCaseAndPersonsLastNameContainsIgnoreCase(firstName, lastName);

    }

    @Override
    public Set<ContentItem> searchByCategory(String categoryName){
        return contentItemRepository.findAllByCategoryNameIgnoreCase(categoryName);
    }


    @Override
    public List<ContentItem> searchTop10ByNumberOfViews(){
        return contentItemRepository.findTop10ByOrderByNumberOfViewsDesc();
    }

    @Override
    public List<ContentItem> searchTop10ByRating(){
        return contentItemRepository.findTop10ByOrderByRatingDesc();
    }


}
