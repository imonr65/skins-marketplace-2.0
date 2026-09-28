package com.marketplace.account.catalog.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record StickerCatalogRequest(
        @NotBlank @Size(min = 2, max = 80) String stickerName
) {
}