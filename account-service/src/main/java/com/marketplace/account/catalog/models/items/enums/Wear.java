package com.marketplace.account.catalog.models.items.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
