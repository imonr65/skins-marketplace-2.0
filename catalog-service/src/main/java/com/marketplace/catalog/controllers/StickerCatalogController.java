package com.marketplace.catalog.controllers;


import com.marketplace.catalog.dto.requests.StickerCatalogRequest;
import com.marketplace.catalog.dto.responses.StickerTemplateResponse;
import com.marketplace.catalog.services.CatalogService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog/stickers")
public class StickerCatalogController {

    private final CatalogService catalogService;

    public StickerCatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping
    public ResponseEntity<StickerTemplateResponse> getStickerTemplateByName(@Valid StickerCatalogRequest request) {
        var response = catalogService.getStickerTemplateByName(request);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/{id}")
    public ResponseEntity<StickerTemplateResponse> getStickerTemplateById(@PathVariable Long id) {
        var response = catalogService.getStickerTemplateById(id);
        return ResponseEntity.ok(response);
    }
}
