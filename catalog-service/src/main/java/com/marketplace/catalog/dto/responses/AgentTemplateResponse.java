package com.marketplace.catalog.dto.responses;

public record AgentTemplateResponse(
        Long agentId,
        String agentName,
        String imageUrl,
        String agentRarity
) {
}