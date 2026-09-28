package com.marketplace.account.catalog.models.items.enums.rarities;

import lombok.Getter;

@Getter
public enum GlovesRarity {
    EXTRAORDINARY("Extraordinary");

    private final String displayName;

    GlovesRarity(String displayName) {
        this.displayName = displayName;
    }
}
