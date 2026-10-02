package com.marketplace.catalog.dto.responses;

public record ContainerTemplateResponse(
        Long containerId,
        String name,
        String rarity,
        String imageUlr
) {
}