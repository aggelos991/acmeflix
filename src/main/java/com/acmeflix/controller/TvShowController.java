package com.acmeflix.controller;

import com.acmeflix.domain.TvShow;
import com.acmeflix.service.TvShowService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("tvshows")
public class TvShowController {

    private final TvShowService tvShowService;

    @GetMapping()
    public List<TvShow> find(@RequestParam(value = "title",required = false) String title){
        if(title == null)
            return tvShowService.findAll();
        else
            return tvShowService.searchByTitle(title);
    }

    @GetMapping("/searchByName/{firstName}&{lastName}")
    public Set<TvShow> searchByPersonsName(@PathVariable String firstName, @PathVariable String lastName){
        return tvShowService.searchByPersonsName(firstName,lastName);
    }

    @GetMapping("/searchByYear/{year}")
    public Set<TvShow> findByYear(@PathVariable Integer year){
        return tvShowService.searchByReleaseYear(year);
    }

    @GetMapping("/searchByCategory/{name}")
    public Set<TvShow> findByCategory(@PathVariable String name){
        return tvShowService.searchByCategory(name);
    }

    @PostMapping
    public ResponseEntity<TvShow> create(@Valid @RequestBody TvShow tvShow){
        return new ResponseEntity<>(tvShowService.create(tvShow), HttpStatus.CREATED);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody TvShow tvShow){
        tvShowService.update(tvShow);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id){
        tvShowService.deleteById(id);
    }

    @GetMapping("/findtop5categories")
    public List<Object[]>  searchTop5Categories(){
        return tvShowService.searchTop5PopularCategories();
    }
}
