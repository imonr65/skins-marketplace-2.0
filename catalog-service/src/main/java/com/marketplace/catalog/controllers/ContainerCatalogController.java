package com.marketplace.catalog.controllers;

import com.marketplace.catalog.dto.requests.ContainerCatalogRequest;
import com.marketplace.catalog.dto.responses.ContainerTemplateResponse;
import com.marketplace.catalog.services.CatalogService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog/containers")
public class ContainerCatalogController {

    private final CatalogService catalogService;

    public ContainerCatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping
    public ResponseEntity<ContainerTemplateResponse> getContainerTemplateByName(@Valid ContainerCatalogRequest request) {
        var response = catalogService.getContainerTemplateByName(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContainerTemplateResponse> getContainerTemplateById(@PathVariable Long id) {
        var response = catalogService.getContainerTemplateById(id);
        return ResponseEntity.ok(response);
    }
}