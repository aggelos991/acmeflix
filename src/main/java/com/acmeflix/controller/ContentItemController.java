package com.acmeflix.controller;

import com.acmeflix.domain.ContentItem;
import com.acmeflix.service.ContentItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("items")
public class ContentItemController {

    private final ContentItemService contentItemService;
    @GetMapping()
    public List<ContentItem> findAll(){
        return contentItemService.findAll();
    }
}
