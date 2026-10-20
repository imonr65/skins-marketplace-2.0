package com.marketplace.catalog.models.items;

import com.marketplace.catalog.models.items.enums.SkinModel;
import com.marketplace.catalog.models.items.enums.Team;
import com.marketplace.catalog.models.items.enums.WearType;
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

    @Column()
    private Double minFloat;

    @Column()
    private Double maxFloat;

    @Column(nullable = false)
    private Boolean stattrak;

    @Column(nullable = false)
    private Boolean souvenir;

    @Column(nullable = false, length = 40)
    @Enumerated(EnumType.STRING)
    private Team team;

    @ElementCollection
    @CollectionTable(
            name = "skin_template_wears",
            joinColumns = @JoinColumn(name = "skin_id")
    )
    @Column(name = "wear", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<WearType> wears = new HashSet<>();

}
