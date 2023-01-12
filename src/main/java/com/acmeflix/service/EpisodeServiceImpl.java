package com.acmeflix.service;

import com.acmeflix.domain.Episode;
import com.acmeflix.repository.EpisodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EpisodeServiceImpl extends BaseServiceImpl<Episode> implements EpisodeService{

    private final EpisodeRepository episodeRepository;

    @Override
    JpaRepository<Episode, Long> getRepository() {
        return episodeRepository;
    }

    @Override
    public Episode searchByTitle(final String title){
        return Optional.ofNullable(episodeRepository.findByTitle(title)).orElseThrow(
                NoSuchElementException::new);
    }
}
