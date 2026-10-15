package com.marketplace.catalog.items;

import com.marketplace.catalog.items.dictionaries.Wear;
import com.marketplace.catalog.items.enums.SkinModel;
import com.marketplace.catalog.items.enums.Team;
import com.marketplace.catalog.items.enums.WearType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
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

    @Column(name = "skin_model", nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private SkinModel skinModel;

    @Column(nullable = false)
    private double minFloat;

    @Column(nullable = false)
    private double maxFloat;

    @Column(nullable = false)
    private boolean stattrak;

    @Column(nullable = false)
    private boolean souvenir;

    @Column(nullable = false, length = 40)
    @Enumerated(EnumType.STRING)
    private Team team;

    @ManyToMany()
    @JoinTable(
            name = "skins_wears",
            joinColumns = @JoinColumn(name = "skin_id"),
            inverseJoinColumns = @JoinColumn(name = "wear_id")
    )
    private Set<Wear> wears;

}
