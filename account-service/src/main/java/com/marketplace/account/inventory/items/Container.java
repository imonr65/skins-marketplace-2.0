package com.marketplace.account.inventory.items;

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


}

//2) *name* - String
//3) *slug* - String
//4) *Item Type* - будет *Container*
//5) *itemPool* - List, хранящий в себе предметы, которые выпадают из этого контейнера.
//6) *Rarity* - Enum. Хранит только один тип - *Base Grade*
//7) *image url*