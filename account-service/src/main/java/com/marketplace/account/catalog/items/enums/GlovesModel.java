package com.marketplace.account.catalog.items.enums;

import lombok.Getter;

@Getter
public enum GlovesModel {

    BLOODHOUND_GLOVES("Bloodhound Gloves"),
    BROKEN_FANG_GLOVES("Broken Fang Gloves"),
    DRIVER_GLOVES("Driver Gloves"),
    HAND_WRAPS("Hand Wraps"),
    HYDRA_GLOVES("Hydra Gloves"),
    MOTO_GLOVES("Moto Gloves"),
    SPECIALIST_GLOVES("Specialist Gloves"),
    SPORT_GLOVES("Sport Gloves");


    private final String displayName;

    GlovesModel(String displayName) {
        this.displayName = displayName;
    }
}
