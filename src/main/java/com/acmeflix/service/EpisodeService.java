package com.acmeflix.service;

import com.acmeflix.domain.Episode;

public interface EpisodeService extends BaseService<Episode,Long> {

    Episode searchByTitle(String title);
}
