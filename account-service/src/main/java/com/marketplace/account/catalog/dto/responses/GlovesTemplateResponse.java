package com.marketplace.account.catalog.dto.responses;

public record GlovesTemplateResponse(
        Long glovesId,
        String imageUrl,
        String glovesName,
        String wear,
        String glovesRarity,
        String glovesModel

) {
}