package com.marketplace.account.catalog.controllers;

import com.marketplace.account.catalog.dto.requests.GlovesCatalogRequest;import com.marketplace.account.catalog.dto.responses.GlovesTemplateResponse;
import com.marketplace.account.catalog.services.CatalogService;
import jakarta.validation.Valid;import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog/gloves")
public class GlovesCatalogController {

    private final CatalogService catalogService;

    public GlovesCatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping
    public ResponseEntity<GlovesTemplateResponse> getGlovesTemplateByName(@Valid GlovesCatalogRequest request) {
        var response = catalogService.getGlovesTemplateByName(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GlovesTemplateResponse> getGlovesTemplateById(@PathVariable Long id) {
        var response = catalogService.getGlovesTemplateById(id);
        return ResponseEntity.ok(response);
    }

}
