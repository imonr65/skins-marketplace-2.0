package com.marketplace.catalog.models.items;

import com.marketplace.catalog.models.items.enums.Team;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
//@Entity
//@Table(name = "agents_templates")
public class Agent extends Item{

    @Enumerated(EnumType.STRING)
    private Team team;
}
