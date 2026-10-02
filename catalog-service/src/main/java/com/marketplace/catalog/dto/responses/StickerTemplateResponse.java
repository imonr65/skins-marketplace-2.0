package com.marketplace.catalog.dto.responses;

public record StickerTemplateResponse(
        Long id,
        String stickerName,
        String imageUrl,
        String stickerRarity
) {
}