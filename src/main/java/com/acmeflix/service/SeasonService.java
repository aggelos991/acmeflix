package com.acmeflix.service;

import com.acmeflix.domain.Season;

public interface SeasonService extends BaseService<Season,Long> {
    Season searchByTitle(String title);

}
