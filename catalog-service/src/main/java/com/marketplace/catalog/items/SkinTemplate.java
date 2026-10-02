package com.marketplace.catalog.items;

import com.marketplace.catalog.items.enums.SkinModel;
import com.marketplace.catalog.items.enums.Team;
import com.marketplace.catalog.items.enums.Wear;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Setter
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "skins_templates")
@PrimaryKeyJoinColumn(name = "item_id")
public class SkinTemplate extends Item{

    @ElementCollection
    @CollectionTable(
            name = "skin_wears",
            joinColumns = @JoinColumn(name = "skin_id")
    )
    @Enumerated(EnumType.STRING)
    private Set<Wear> wears;

    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private SkinModel skinModel;

    private double minFloat;

    private double maxFloat;

    private boolean stattrak;

    private boolean souvenir;

    @Enumerated(EnumType.STRING)
    private Team team;

//    @ManyToMany(mappedBy = "contains")
//    private Set<Crate> crates;
//
//    @ManyToMany(mappedBy = "items")
//    private Set<ItemCollection> itemCollections;

}
