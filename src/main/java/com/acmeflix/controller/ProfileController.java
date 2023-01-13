package com.acmeflix.controller;

import com.acmeflix.domain.Profile;
import com.acmeflix.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("profiles")
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping()
    public List<Profile> findAll(){
        return  profileService.findAll();
    }
}
