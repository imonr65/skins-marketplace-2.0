package com.marketplace.account.catalog.models.items.enums;

import lombok.Getter;

@Getter
public enum ItemType {

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

    ItemType(String displayName) {
        this.displayName = displayName;
    }
}
