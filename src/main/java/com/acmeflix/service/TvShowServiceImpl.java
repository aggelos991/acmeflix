package com.acmeflix.service;

import com.acmeflix.domain.TvShow;
import com.acmeflix.repository.TvShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TvShowServiceImpl extends BaseServiceImpl<TvShow> implements TvShowService {

    private final TvShowRepository tvShowRepository;

    @Override
    JpaRepository<TvShow, Long> getRepository() {
        return tvShowRepository;
    }

    @Override
    public List<TvShow> searchByTitle(final String title){
        return Optional.ofNullable(tvShowRepository.findByTitleContainsIgnoreCase(title)).orElseThrow(
                NoSuchElementException::new);
    }

    @Override
    public Set<TvShow> searchByReleaseYear(Integer year){
        return tvShowRepository.findAllByReleaseYear(year);
    }

    @Override
    public Set<TvShow> searchByPersonsName(String firstName, String lastName){
        return tvShowRepository.findAllByPersonsFirstNameContainsIgnoreCaseAndPersonsLastNameContainsIgnoreCase(firstName, lastName);

    }

    @Override
    public Set<TvShow> searchByCategory(String categoryName){
        return tvShowRepository.findAllByCategoryNameIgnoreCase(categoryName);
    }

    @Override
    public List<Object[]> searchTop5PopularCategories(){
        return tvShowRepository.findTop5PopularCategories();
    }
}
