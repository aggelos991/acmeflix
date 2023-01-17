package com.acmeflix.service;

import com.acmeflix.domain.Season;

import java.util.List;

public interface SeasonService extends BaseService<Season,Long> {

    List<Season> searchByName(String name);

}
