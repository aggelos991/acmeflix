package com.acmeflix.service;

import com.acmeflix.domain.Season;
import com.acmeflix.repository.SeasonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SeasonServiceImpl extends BaseServiceImpl<Season> implements SeasonService{

    private final SeasonRepository seasonRepository;

    @Override
    JpaRepository<Season, Long> getRepository() {
        return seasonRepository;
    }

    @Override
    public List<Season> searchByName(final String name){
        return Optional.ofNullable(seasonRepository.findByNameContainsIgnoreCase(name)).orElseThrow(
                NoSuchElementException::new);
    }
}
