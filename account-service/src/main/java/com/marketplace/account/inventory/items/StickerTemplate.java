package com.marketplace.account.inventory.items;


import com.marketplace.account.inventory.items.enums.StickerRarity;
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

    @Column(nullable = false)
    private String name;

    private String imageUrl;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StickerRarity stickerRarity;

}

