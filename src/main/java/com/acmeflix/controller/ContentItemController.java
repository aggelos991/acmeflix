package com.acmeflix.controller;

import com.acmeflix.service.ContentItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("content")
public class ContentItemController {

    private final ContentItemService contentItemService;

    @GetMapping("/top10/views")
    public List<Object[]> findTop10ByViews() {
        return contentItemService.searchTop10ByNumberOfViews();
    }

    @GetMapping("/top10/rating")
    public List<Object[]> findTop10ByRating() {
        return contentItemService.searchTop10ByRating();
    }
}
