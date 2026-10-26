package com.marketplace.catalog.dto.brokers;

public sealed interface ItemDetails
        permits  SkinDetails, AgentDetails, StickerDetails, CrateDetails, CollectionDetails{
}
