package com.marketplace.catalog.models.items.enums;

import lombok.Getter;

@Getter
public enum WearType {
    FACTORY_NEW("Factory New"),
    MINIMAL_WEAR("Minimal Wear"),
    FIELD_TESTED("Field-Tested"),
    WELL_WORN("Well-Worn"),
    BATTLE_SCARRED("Battle-Scarred");

    private final String displayName;

    WearType(String displayName) {
        this.displayName = displayName;
    }
}
