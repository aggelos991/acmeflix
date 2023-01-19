package com.acmeflix.controller;

import com.acmeflix.domain.Movie;
import com.acmeflix.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("movies")
public class MovieController {

    private final MovieService movieService;

    @GetMapping()
    public List<Movie> find(@RequestParam(value = "title", required = false) String title) {
        if (title == null)
            return movieService.findAll();
        else
            return movieService.searchByTitle(title);
    }

    @GetMapping("/searchByName/{firstName}&{lastName}")
    public Set<Movie> searchByPersonsName(@PathVariable String firstName, @PathVariable String lastName) {
        return movieService.searchByPersonsName(firstName, lastName);
    }

    @GetMapping("/searchByYear/{year}")
    public Set<Movie> findByYear(@PathVariable Integer year) {
        return movieService.searchByReleaseYear(year);
    }

    @GetMapping("/searchByCategory/{name}")
    public Set<Movie> findByCategory(@PathVariable String name) {
        return movieService.searchByCategory(name);
    }

    @PostMapping
    public ResponseEntity<Movie> create(@Valid @RequestBody Movie movie) {
        return new ResponseEntity<>(movieService.create(movie), HttpStatus.CREATED);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody Movie movie) {
        movieService.update(movie);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        movieService.deleteById(id);
    }

    @GetMapping("/findtop5categories")
    public List<Object[]>  searchTop5Categories(){
        return movieService.searchTop5PopularCategories();
    }
}
