package com.marketplace.account.catalog.dto.responses;

public record StickerTemplateResponse(
        Long id,
        String stickerName,
        String imageUrl,
        String stickerRarity
) {
}