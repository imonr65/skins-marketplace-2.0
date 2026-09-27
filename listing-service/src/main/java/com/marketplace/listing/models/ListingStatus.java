package com.marketplace.listing.models;

import lombok.Getter;

@Getter
public enum ListingStatus {
    ACTIVE("Active"),
    RESERVED("Reserved"),
    SOLD("Sold");

    private final String displayName;

    ListingStatus(String displayName) {
        this.displayName = displayName;
    }
}
