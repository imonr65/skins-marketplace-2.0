package com.marketplace.catalog.dto.brokers;

import java.time.Instant;
import java.util.UUID;

public record CatalogItemUpsertedEvent(
        UUID eventId,
        int eventVersion,
        Instant occurredAt,
        CatalogItemSnapshot data
) {
}
