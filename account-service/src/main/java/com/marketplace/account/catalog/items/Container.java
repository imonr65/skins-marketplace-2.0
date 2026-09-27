package com.marketplace.account.catalog.items;

import com.marketplace.account.catalog.items.enums.rarities.ContainerRarity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Container {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 80)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ContainerRarity rarity;

    @Column
    private String imageUrl;

}