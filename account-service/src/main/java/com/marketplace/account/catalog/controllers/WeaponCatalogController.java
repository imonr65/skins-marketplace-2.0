package com.marketplace.account.catalog.controllers;

import com.marketplace.account.catalog.dto.requests.WeaponCatalogRequest;
import com.marketplace.account.catalog.dto.responses.WeaponTemplateResponse;
import com.marketplace.account.catalog.services.CatalogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/catalog/weapons")
public class WeaponCatalogController {

    private final CatalogService catalogService;

    public WeaponCatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<WeaponTemplateResponse> getWeaponTemplateById(@PathVariable Long id) {
        var response = catalogService.getWeaponTemplateById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<WeaponTemplateResponse> getWeaponTemplateByName(WeaponCatalogRequest request) {
        var response = catalogService.getWeaponTemplateByName(request);
        return ResponseEntity.ok(response);
    }
}
