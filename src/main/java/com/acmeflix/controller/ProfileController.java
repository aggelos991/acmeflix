package com.acmeflix.controller;

import com.acmeflix.domain.Profile;
import com.acmeflix.service.ProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("profiles")
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping()
    public ResponseEntity<List<Profile>> findAll() {
        return ResponseEntity.ok(profileService.findAll());
    }

    @PostMapping
    public ResponseEntity<Profile> create(@Valid @RequestBody Profile profile) {
        return new ResponseEntity<>(profileService.create(profile), HttpStatus.CREATED);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody Profile profile) {
        profileService.update(profile);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        profileService.deleteById(id);
    }
}
