package com.marketplace.account.catalog.dto.responses;

public record WeaponTemplateResponse(
        Long weaponId,
        String weaponName,
        String wear,
        String weaponModel,
        String weaponRarity,
        String imageUrl
) {
}