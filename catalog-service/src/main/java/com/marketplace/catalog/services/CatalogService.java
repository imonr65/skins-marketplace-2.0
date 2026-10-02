package com.marketplace.catalog.services;


import com.marketplace.catalog.dto.requests.*;
import com.marketplace.catalog.dto.responses.*;

public interface CatalogService {

    WeaponTemplateResponse getWeaponTemplateById(Long id);

    WeaponTemplateResponse getWeaponTemplateByName(WeaponCatalogRequest request);

    GlovesTemplateResponse getGlovesTemplateById(Long id);

    GlovesTemplateResponse getGlovesTemplateByName(GlovesCatalogRequest request);

    StickerTemplateResponse getStickerTemplateById(Long id);

    StickerTemplateResponse getStickerTemplateByName(StickerCatalogRequest request);

    AgentTemplateResponse getAgentTemplateById(Long id);

    AgentTemplateResponse getAgentTemplateByName(AgentCatalogRequest request);

    ContainerTemplateResponse getContainerTemplateById(Long id);

    ContainerTemplateResponse getContainerTemplateByName(ContainerCatalogRequest request);
}
