package com.marketplace.catalog.items;

import com.marketplace.catalog.items.enums.ItemCategory;
import com.marketplace.catalog.items.enums.rarities.Rarity;
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

    @Column(nullable = false, length = 80)
    private String name;

    @Column(nullable = false, length = 40)
    @Enumerated(EnumType.STRING)
    private ItemCategory category;

    @Column(nullable = false, length = 40)
    @Enumerated(EnumType.STRING)
    private Rarity rarity;

    @Column(nullable = false)
    private String description;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

