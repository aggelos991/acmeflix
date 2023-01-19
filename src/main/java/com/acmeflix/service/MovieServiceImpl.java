package com.acmeflix.service;

import com.acmeflix.domain.Movie;
import com.acmeflix.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl extends BaseServiceImpl<Movie> implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    JpaRepository<Movie, Long> getRepository() {
        return movieRepository;
    }

    @Override
        public List<Movie> searchByTitle(final String title){
        return Optional.ofNullable(movieRepository.findByTitleContainsIgnoreCase(title)).orElseThrow(
                NoSuchElementException::new);
    }

    @Override
    public Set<Movie> searchByReleaseYear(Integer year){
        return movieRepository.findAllByReleaseYear(year);
    }

    @Override
    public Set<Movie> searchByPersonsName(String firstName, String lastName){
        return movieRepository.findAllByPersonsFirstNameContainsIgnoreCaseAndPersonsLastNameContainsIgnoreCase(firstName, lastName);

    }

    @Override
    public Set<Movie> searchByCategory(String categoryName){
        return movieRepository.findAllByCategoryNameIgnoreCase(categoryName);
    }

    @Override
    public List<Object[]>  searchTop5PopularCategories(){
        return movieRepository.findTop5PopularCategories();
    }
}
