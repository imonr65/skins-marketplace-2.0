package com.marketplace.catalog.mappers;

import com.marketplace.catalog.dto.items.SkinInfo;
import com.marketplace.catalog.models.items.SkinTemplate;
import com.marketplace.catalog.models.items.enums.ItemCategory;
import com.marketplace.catalog.models.items.enums.SkinModel;
import com.marketplace.catalog.models.items.enums.Team;
import com.marketplace.catalog.models.items.enums.WearType;
import com.marketplace.catalog.models.items.enums.rarities.Rarity;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class SkinTemplateMapper {

    public SkinTemplate toEntity(SkinInfo skinInfo) {
        return SkinTemplate.builder()
                .name(skinInfo.name())
                .description(skinInfo.description())
                .imageUrl(skinInfo.image())
                .externalId(skinInfo.id())
                .category(mapItemCategory(skinInfo.category().name()))
                .rarity(mapRarity(skinInfo.rarity().name()))
                .skinModel(mapSkinModel(skinInfo.weapon().name()))
                .minFloat(skinInfo.minFloat())
                .maxFloat(skinInfo.maxFloat())
                .stattrak(skinInfo.stattrak())
                .souvenir(skinInfo.souvenir())
                .team(mapTeam(skinInfo.team()))
                .wears(mapWears(skinInfo.wears()))
                .build();
    }


    private Set<WearType> mapWears(java.util.List<SkinInfo.Wear> wears) {
        if (wears == null) {
            return Collections.emptySet();
        }

        return wears.stream()
                .map(SkinInfo.Wear::name)
                .map(this::mapWearType)
                .collect(Collectors.toSet());
    }

    private WearType mapWearType(String name) {
        return switch (name) {
            case "Factory New" -> WearType.FACTORY_NEW;
            case "Minimal Wear" -> WearType.MINIMAL_WEAR;
            case "Field-Tested" -> WearType.FIELD_TESTED;
            case "Well-Worn" -> WearType.WELL_WORN;
            case "Battle-Scarred" -> WearType.BATTLE_SCARRED;
            default -> throw new IllegalArgumentException(
                    "Unknown wear type: " + name
            );
        };
    }

    private Team mapTeam(SkinInfo.Team team) {
        if (team == null || team.name() == null) {
            return null;
        }

        return Team.valueOf(normalizeEnumName(team.name()));
    }

    private SkinModel mapSkinModel(String name) {
        if (name == null) {
            return null;
        }

        return SkinModel.valueOf(normalizeEnumName(name));
    }

    private ItemCategory mapItemCategory(String name) {
        if (name == null) {
            return null;
        }

        return ItemCategory.valueOf(normalizeEnumName(name));
    }


    private Rarity mapRarity(String name) {
        if (name == null) {
            return null;
        }

        return Rarity.valueOf(normalizeEnumName(name));
    }

    private String normalizeEnumName(String name) {
        return name.trim()
                .toUpperCase(Locale.ROOT)
                .replaceAll("[\\s-]+", "_");
    }


}
