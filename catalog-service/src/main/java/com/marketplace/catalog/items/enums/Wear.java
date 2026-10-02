package com.marketplace.catalog.items.enums;

import lombok.Getter;

@Getter
public enum Wear {
    Factory_New("Factory New"),
    Minimal_Wear("Minimal Wear"),
    Field_Tested("Field-Tested"),
    Well_Worn("Well-Worn"),
    Battle_Scarred("Battle-Scarred");

    private final String displayName;

    Wear(String displayName) {
        this.displayName = displayName;
    }
}
