package com.marketplace.account.catalog.models.items;

import com.marketplace.account.catalog.models.items.enums.Team;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Collection;
import java.util.Set;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "agents_templates")
public class Agent extends Item{

    private Set<Collection> collections;

    @Enumerated(EnumType.STRING)
    private Team team;
}
