package com.acmeflix.controller;

import com.acmeflix.domain.Season;
import com.acmeflix.service.SeasonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("seasons")
public class SeasonController {

    private final SeasonService seasonService;

    @GetMapping()
    public List<Season> find(@RequestParam(value = "title",required = false) String name){
        if(name == null)
            return seasonService.findAll();
        else
            return seasonService.searchByName(name);
    }

    @PostMapping
    public ResponseEntity<Season> create(@Valid @RequestBody Season season){
        return new ResponseEntity<>(seasonService.create(season), HttpStatus.CREATED);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody Season season){
        seasonService.update(season);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id){
        seasonService.deleteById(id);
    }
}
