package com.marketplace.catalog.controllers;

import com.marketplace.catalog.dto.requests.AgentCatalogRequest;
import com.marketplace.catalog.dto.responses.AgentTemplateResponse;
import com.marketplace.catalog.services.CatalogService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog/agents")
public class AgentCatalogController {

    private final CatalogService catalogService;

    public AgentCatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping
    public ResponseEntity<AgentTemplateResponse> getAgentTemplateByName(@Valid AgentCatalogRequest request) {
        var response = catalogService.getAgentTemplateByName(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgentTemplateResponse> getAgentTemplateByName(@PathVariable Long id) {
        var response = catalogService.getAgentTemplateById(id);
        return ResponseEntity.ok(response);
    }
}
