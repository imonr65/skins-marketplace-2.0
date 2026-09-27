package com.marketplace.account.catalog.items.enums.rarities;

import lombok.Getter;

@Getter
public enum AgentRarity {
    //Todo: задать цвета редкостям
    MASTER("Master", "ДОЛЖЕН БЫТЬ КРАСНЫМ"),
    SUPERIOR("Superior", "РОЗОВЫЙ"),
    EXCEPTIONAL("Exceptional", "Фиол"),
    DISTINGUISHED("Distinguished", "Темно синий");


    private final String displayName;
    private final String rarityColor;

    AgentRarity(String displayName, String rarityColor) {
        this.displayName = displayName;
        this.rarityColor = rarityColor;
    }
}
