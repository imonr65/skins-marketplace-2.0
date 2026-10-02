package com.marketplace.account.catalog.models.items;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "crates_templates")
@PrimaryKeyJoinColumn(name = "item_id")
public class Crate extends Item{

    private LocalDate firstSaleDate;

    @ManyToMany
    @JoinTable(
            name = "crate_items",
            joinColumns = @JoinColumn(name = "crate_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private Set<Item> contains;
}