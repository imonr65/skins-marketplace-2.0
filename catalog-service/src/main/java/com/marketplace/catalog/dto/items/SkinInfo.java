package com.marketplace.catalog.dto.items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SkinInfo(
        String name,
        String description,
        Weapon weapon,
        Category category,
        @JsonProperty("min_float") Double minFloat,
        @JsonProperty("max_float") Double maxFloat,
        Rarity rarity,
        Boolean stattrak,
        Boolean souvenir,
        List<Wear> wears,
        List<Collection> collections,
        List<Crate> crates,
        Team team,
        String image,
        String id
) {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Weapon(String name) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Category(String name) {}

    // у меня есть Enum с другими цветами. Можно добавить поле 'color' и брать оттуда цвет редкости
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Rarity(String name) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Wear(String name) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Collection(String name, String image) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Crate(String name, String image) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Team(String name) {}

}