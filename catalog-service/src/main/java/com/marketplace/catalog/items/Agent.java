package com.marketplace.catalog.items;

import com.marketplace.catalog.items.enums.Team;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "agents_templates")
public class Agent extends Item{

    @Enumerated(EnumType.STRING)
    private Team team;
}
