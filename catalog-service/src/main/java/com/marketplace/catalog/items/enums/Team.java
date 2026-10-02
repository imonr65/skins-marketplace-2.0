package com.marketplace.catalog.items.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Team {
    BOTH_TEAMS("Both Teams"),
    TERRORIST("Terrorist"),
    COUNTER_TERRORIST("Counter-Terrorist");

    private final String displayName;

    Team(String displayName) {
        this.displayName = displayName;
    }


    private static Team getByDisplayName(String displayName) {
        return Arrays.stream(values())
                .filter(d -> d.displayName.equals(displayName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown Team: " + displayName));
    }
}
