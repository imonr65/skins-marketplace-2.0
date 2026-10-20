package com.marketplace.catalog.models.items.enums;

import lombok.Getter;

@Getter
public enum ItemCategory {

    PISTOLS("Pistols"),
    RIFLES("Rifles"),
    SNIPER_RIFLE("Sniper Rifle"),
    SMGS("SMGS"),
    EQUIPMENT("Equipment"),
    HEAVY("Heavy"),
    SHOTGUN("Shotgun"),
    KNIVES("Knives"),

    GLOVES("Gloves"),

    CONTAINER("Container"),

    AGENT("Agent"),

    STICKER("Sticker");

    private final String displayName;

    ItemCategory(String displayName) {
        this.displayName = displayName;
    }
}
