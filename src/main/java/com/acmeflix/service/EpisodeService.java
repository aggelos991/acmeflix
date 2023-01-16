package com.acmeflix.service;

import com.acmeflix.domain.Episode;

import java.util.List;

public interface EpisodeService extends BaseService<Episode,Long> {

    List<Episode> searchByTitle(String title);

}
