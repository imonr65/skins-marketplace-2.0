package com.marketplace.catalog.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record WeaponCatalogRequest(
        @NotBlank @Size(min = 2, max = 80) String weaponName
) {
}
