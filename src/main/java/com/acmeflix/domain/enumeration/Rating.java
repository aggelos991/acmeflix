package com.acmeflix.domain.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Rating {
    LIKE(0),DISLIKE(1);

    private final Integer rating;

}
