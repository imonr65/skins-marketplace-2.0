package com.marketplace.account.inventory.items.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public enum WeaponRarity {

    CONSUMER_GRADE("Consumer Grade", "#B0C3D9"),
    INDUSTRIAL_GRADE("Industrial Grade", "#5E98D9"),
    MIL_SPEC_GRADE("Mil-Spec Grade", "#4B69FF"),
    RESTRICTED("Restricted", "#8847FF"),
    CLASSIFIED("Classified", "#D32CE6"),
    COVERT("Covert", "#EB4B4B");

    private final String displayName;
    private final String color;

    WeaponRarity(String displayName, String color) {
        this.displayName = displayName;
        this.color = color;
    }
}
