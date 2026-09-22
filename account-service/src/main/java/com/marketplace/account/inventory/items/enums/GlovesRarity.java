package com.marketplace.account.inventory.items.enums;

import lombok.Getter;

@Getter
public enum GlovesRarity {
    EXTRAORDINARY("Extraordinary");

    private final String displayName;

    GlovesRarity(String displayName) {
        this.displayName = displayName;
    }
}
