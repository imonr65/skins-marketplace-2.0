package com.marketplace.account.catalog.items;

import com.marketplace.account.catalog.items.enums.GlovesModel;
import com.marketplace.account.catalog.items.enums.ItemType;
import com.marketplace.account.catalog.items.enums.Wear;
import com.marketplace.account.catalog.items.enums.rarities.GlovesRarity;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class GlovesTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Wear wear;

    @Column
    private String imageUrl;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private GlovesRarity glovesRarity;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ItemType itemType;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private GlovesModel glovesModel;

}