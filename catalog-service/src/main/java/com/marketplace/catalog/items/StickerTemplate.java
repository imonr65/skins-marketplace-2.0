package com.marketplace.catalog.items;

import com.marketplace.catalog.items.enums.StickerEffect;
import com.marketplace.catalog.items.enums.StickerType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stickers_templates")
@PrimaryKeyJoinColumn(name = "item_id")
public class StickerTemplate extends Item{

    private String tournament;

    @Enumerated(EnumType.STRING)
    private StickerType type;

    @Column
    @Enumerated(EnumType.STRING)
    private StickerEffect effect;

}

