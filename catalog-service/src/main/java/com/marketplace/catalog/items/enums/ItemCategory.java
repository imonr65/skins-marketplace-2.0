package com.marketplace.catalog.items.enums;

import lombok.Getter;

@Getter
public enum ItemCategory {

    PISTOL("Pistol"),
    RIFLE("Rifle"),
    SNIPER_RIFLE("Sniper Rifle"),
    SMG("SMG"),
    HEAVY("Heavy"),
    SHOTGUN("Shotgun"),
    KNIFE("Knife"),

    GLOVES("Gloves"),

    CONTAINER("Container"),

    AGENT("Agent"),

    STICKER("Sticker");

    private final String displayName;

    ItemCategory(String displayName) {
        this.displayName = displayName;
    }
}
