package com.marketplace.account.catalog.dto.responses;

public record AgentTemplateResponse(
        Long agentId,
        String agentName,
        String imageUrl,
        String agentRarity
) {
}