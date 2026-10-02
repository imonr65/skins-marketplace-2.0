package com.marketplace.account.catalog.models.items.enums;

import lombok.Getter;

@Getter
public enum StickerEffect {

    PAPER("Paper"),
    GLOSSY("Glossy"),
    GLITTER("Glitter"),
    HOLO("Holographic"),
    FOIL("Foil"),
    GOLD("Gold"),
    LENTICULAR("Lenticular"),
    EMBROIDERED("Embroidered"),
    OTHER("Other");

    private final String displayName;

    StickerEffect(String displayName) {
        this.displayName = displayName;
    }

    public static StickerEffect fromDisplayName(String displayName) {
        for (StickerEffect effect : values()) {
            if (effect.displayName.equalsIgnoreCase(displayName)) {
                return effect;
            }
            if (effect == HOLO && "Holo".equalsIgnoreCase(displayName)) {
                return HOLO;
            }
        }
        return OTHER;
    }
}
