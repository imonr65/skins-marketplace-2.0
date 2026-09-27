package com.marketplace.account.catalog.items;

import com.marketplace.account.catalog.items.enums.ItemType;
import com.marketplace.account.catalog.items.enums.WeaponModel;
import com.marketplace.account.catalog.items.enums.Wear;
import com.marketplace.account.catalog.items.enums.rarities.WeaponRarity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WeaponTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Wear wear;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ItemType itemType;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private WeaponModel weaponModel;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private WeaponRarity weaponRarity;

    @Column()
    private String imageUrl;

}
