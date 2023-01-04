package com.acmeflix.domain.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SubscriptionTier {
    BASIC("Basic"),
    STANDARD("Standard"),
    PREMIUM("Premium");

    private final String tier;
}
