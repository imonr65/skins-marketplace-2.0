package com.marketplace.account.catalog.models.items;

import com.marketplace.account.catalog.models.items.enums.rarities.StickerRarity;
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
public class StickerTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 80)
    private String stickerName;

    private String imageUrl;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StickerRarity stickerRarity;

}

