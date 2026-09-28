package com.marketplace.account.catalog.models.items;

import com.marketplace.account.catalog.models.items.enums.WeaponModel;
import com.marketplace.account.catalog.models.items.enums.Wear;
import com.marketplace.account.catalog.models.items.enums.rarities.WeaponRarity;
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

    @Column(nullable = false, length = 80)
    private String weaponName;

    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private Wear wear;

    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private WeaponModel weaponModel;

    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private WeaponRarity weaponRarity;

    @Column()
    private String imageUrl;

}
