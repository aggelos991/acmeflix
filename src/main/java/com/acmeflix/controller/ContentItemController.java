package com.acmeflix.controller;

import com.acmeflix.domain.ContentItem;
import com.acmeflix.service.ContentItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("items")
public class ContentItemController {

    private final ContentItemService contentItemService;

    @GetMapping()
    public List<ContentItem> find(@RequestParam(value = "title",required = false) String title){
        if(title == null)
            return contentItemService.findAll();
        else
            return contentItemService.searchByTitle(title);
    }

    @GetMapping("/searchByName/{firstName}&{lastName}")
    public Set<ContentItem> searchByPersonsName(@PathVariable String firstName,@PathVariable String lastName){
        return contentItemService.searchByPersonsName(firstName,lastName);
    }

    @GetMapping("/searchByYear/{year}")
    public Set<ContentItem> findByYear(@PathVariable Integer year){
        return contentItemService.searchByReleaseYear(year);
    }

    @GetMapping("/searchByCategory/{name}")
    public Set<ContentItem> findByCategory(@PathVariable String name){
        return contentItemService.searchByCategory(name);
    }

}
