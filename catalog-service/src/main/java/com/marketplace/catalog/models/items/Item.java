package com.marketplace.catalog.models.items;

import com.marketplace.catalog.models.items.enums.ItemCategory;
import com.marketplace.catalog.models.items.enums.rarities.Rarity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Objects;
import java.util.UUID;

@Setter
@Getter
@SuperBuilder
@Entity
@Table(name = "items")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "item_type")
@NoArgsConstructor
public abstract class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String imageUrl;

    @Column(name = "item_name", nullable = false, length = 80)
    private String name;

    @Column(nullable = false, length = 40)
    @Enumerated(EnumType.STRING)
    private ItemCategory category;

    @Column(nullable = false, length = 40)
    @Enumerated(EnumType.STRING)
    private Rarity rarity;

    @Column(nullable = false, length = 1000)
    private String description;

    // для будущей синхронизацией с ценами и апи Steam:
    @Column(name = "market_hash_name", nullable = false, unique = true)
    private String marketHashName;

    @Column(name = "external_id", nullable = false, length = 100, unique = true)
    private String externalId;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id) && Objects.equals(externalId, item.externalId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, externalId);
    }
}

