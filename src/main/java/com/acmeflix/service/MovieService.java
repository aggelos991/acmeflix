package com.acmeflix.service;

import com.acmeflix.domain.Category;
import com.acmeflix.domain.Movie;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface MovieService extends BaseService<Movie,Long>{

    List<Movie> searchByTitle(String title);

    Set<Movie> searchByReleaseYear(Integer year);

    Set<Movie> searchByCategory(String categoryName);

    Set<Movie> searchByPersonsName(String firstName, String lastName);

    List<Movie> searchTop10ByNumberOfViews();

    List<Movie> searchTop10ByRating();

    List<Object[]> searchTop5PopularCategories();
}
