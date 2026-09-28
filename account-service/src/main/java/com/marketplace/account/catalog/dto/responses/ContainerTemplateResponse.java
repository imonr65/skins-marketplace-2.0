package com.marketplace.account.catalog.dto.responses;

public record ContainerTemplateResponse(
        Long containerId,
        String name,
        String rarity,
        String imageUlr
) {
}