package com.marketplace.catalog.dto.brokers;

import com.marketplace.catalog.models.items.enums.ItemCategory;

import java.util.UUID;

public record CatalogItemSnapshot(
        UUID templateId,
        ItemCategory category,
        String name,
        String imageUrl,
        ItemDetails details
) {
}
