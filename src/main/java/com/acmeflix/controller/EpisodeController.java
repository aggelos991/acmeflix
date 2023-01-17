package com.acmeflix.controller;

import com.acmeflix.domain.Episode;
import com.acmeflix.service.EpisodeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("episodes")
public class EpisodeController {

    private final EpisodeService episodeService;

    @GetMapping()
    public List<Episode> find(@RequestParam(value = "title",required = false) String title){
        if(title == null)
            return episodeService.findAll();
        else
            return episodeService.searchByTitle(title);
    }

    @PostMapping
    public ResponseEntity<Episode> create(@Valid @RequestBody Episode episode){
        return new ResponseEntity<>(episodeService.create(episode), HttpStatus.CREATED);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody Episode episode){
        episodeService.update(episode);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id){
        episodeService.deleteById(id);
    }
}
