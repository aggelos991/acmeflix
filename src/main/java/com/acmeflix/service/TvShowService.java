package com.acmeflix.service;

import com.acmeflix.domain.TvShow;

import java.util.List;
import java.util.Set;

public interface TvShowService extends BaseService<TvShow,Long>{

    List<TvShow> searchByTitle(String title);

    Set<TvShow> searchByReleaseYear(Integer year);

    Set<TvShow> searchByCategory(String categoryName);

    Set<TvShow> searchByPersonsName(String firstName, String lastName);
    List<Object[]> searchTop5PopularCategories();

}
