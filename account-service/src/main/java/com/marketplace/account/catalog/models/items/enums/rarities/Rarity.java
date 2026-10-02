package com.marketplace.account.catalog.models.items.enums.rarities;

import lombok.Getter;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public enum Rarity {
    // === WEAPONS ===
    CONSUMER_GRADE("Consumer Grade", "#B0C3D9", RarityScope.WEAPON),
    INDUSTRIAL_GRADE("Industrial Grade", "#5E98D9", RarityScope.WEAPON),
    MIL_SPEC_GRADE("Mil-Spec Grade", "#4B69FF", RarityScope.WEAPON),
    RESTRICTED("Restricted", "#8847FF", RarityScope.WEAPON),
    CLASSIFIED("Classified", "#D32CE6", RarityScope.WEAPON),
    COVERT("Covert", "#EB4B4B", RarityScope.WEAPON),

    // === AGENTS ===
    DISTINGUISHED("Distinguished", "#4B69FF", RarityScope.AGENT),
    EXCEPTIONAL("Exceptional", "#8847FF", RarityScope.AGENT),
    SUPERIOR("Superior", "#D32CE6", RarityScope.AGENT),
    MASTER("Master", "#EB4B4B", RarityScope.AGENT),

    // === GLOVES ===
    EXTRAORDINARY("Extraordinary", "#FFD700", RarityScope.GLOVES),

    // === CONTAINERS ===
    BASE_GRADE("Base Grade", "#B0C3D9", RarityScope.CONTAINER),

    // === STICKERS ===
    HIGH_GRADE("High Grade", "#4B69FF", RarityScope.STICKER),
    REMARKABLE("Remarkable", "#D32CE6", RarityScope.STICKER),
    EXOTIC("Exotic", "#EB4B4B", RarityScope.STICKER);

    private final String displayName;
    private final String color;
    private final RarityScope scope;

    Rarity(String displayName, String color, RarityScope scope) {
        this.displayName = displayName;
        this.color = color;
        this.scope = scope;
    }

    public static Set<Rarity> getByScope(RarityScope scope) {
        return Arrays.stream(values())
                .filter(s -> s.scope.equals(scope))
                .collect(Collectors.toSet());
    }

    public static Rarity fromDisplayName(String displayName) {
        return Arrays.stream(values())
                .filter(r -> r.displayName.equals(displayName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown Rarity: " + displayName));
    }
}
