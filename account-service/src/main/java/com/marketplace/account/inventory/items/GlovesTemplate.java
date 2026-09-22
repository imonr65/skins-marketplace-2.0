package com.marketplace.account.inventory.items;

import com.marketplace.account.inventory.items.enums.GlovesModel;
import com.marketplace.account.inventory.items.enums.GlovesRarity;
import com.marketplace.account.inventory.items.enums.ItemType;
import com.marketplace.account.inventory.items.enums.Wear;
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