package com.marketplace.account.catalog.models.items.enums.rarities;

import lombok.Getter;

@Getter
public enum ContainerRarity {
    BASE_GRADE("Base Grade");

    private final String displayName;

    ContainerRarity(String displayName) {
        this.displayName = displayName;
    }
}
