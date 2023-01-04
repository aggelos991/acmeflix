package com.acmeflix.domain.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MaturityRating {
    R_3("3+"),
    R_7("7+"),
    R_13("13+"),
    R_16("16+"),
    R_18("18+");

    private final String maturityRating;
}
