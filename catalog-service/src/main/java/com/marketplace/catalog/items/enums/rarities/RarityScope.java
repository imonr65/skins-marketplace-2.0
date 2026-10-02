package com.marketplace.catalog.items.enums.rarities;

import lombok.Getter;

@Getter
public enum RarityScope {
    WEAPON("Weapon"),
    GLOVES("Gloves"),
    CONTAINER("Container"),
    AGENT("Agent"),
    STICKER("Sticker");

    private final String displayName;

    RarityScope(String displayName) {
        this.displayName = displayName;
    }
}
