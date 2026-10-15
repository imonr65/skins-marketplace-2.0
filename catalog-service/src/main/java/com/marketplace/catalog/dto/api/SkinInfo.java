package com.marketplace.catalog.dto.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SkinInfo(
        String name,
        String description,
        Weapon weapon,
        Category category,
        @JsonProperty("min_float") double minFloat,
        @JsonProperty("max_float") double maxFloat,
        Rarity rarity,
        boolean stattrak,
        boolean souvenir,
        List<Wear> wears,
        List<Collection> collections,
        List<Crate> crates,
        Team team,
        String image,
        @JsonProperty("market_hash_name") String marketHashName,
        String id
) {

    @JsonIgnoreProperties(ignoreUnknown = true)
    private record Weapon(String name) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    private record Category(String name) {}

    // у меня есть Enum с другими цветами. Можно добавить поле 'color' и брать оттуда цвет редкости
    @JsonIgnoreProperties(ignoreUnknown = true)
    private record Rarity(String name) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    private record Wear(String name) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    private record Collection(String name, String image) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    private record Crate(String name, String image) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    private record Team(String name) {}

}