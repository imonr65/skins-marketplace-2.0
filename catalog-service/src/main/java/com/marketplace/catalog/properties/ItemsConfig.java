package com.marketplace.catalog.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.items")
public record ItemsConfig(
        ItemParameters skins,
        ItemParameters agents,
        ItemParameters collections,
        ItemParameters crates,
        ItemParameters stickers
) {

    public record ItemParameters(String url) {}
}
