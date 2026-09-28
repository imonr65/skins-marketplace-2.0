package com.marketplace.account.catalog.models.items;

import com.marketplace.account.catalog.models.items.enums.GlovesModel;
import com.marketplace.account.catalog.models.items.enums.Wear;
import com.marketplace.account.catalog.models.items.enums.rarities.GlovesRarity;
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

    @Column(nullable = false, length = 80)
    private String name;

    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private Wear wear;

    @Column
    private String imageUrl;

    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private GlovesRarity glovesRarity;

    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private GlovesModel glovesModel;

}