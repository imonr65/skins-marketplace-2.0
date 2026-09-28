package com.marketplace.account.catalog.models.items;

import com.marketplace.account.catalog.models.items.enums.rarities.AgentRarity;
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
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 80, unique = true)
    private String agentName;

    @Column
    private String imageUrl;

    @Column(nullable = false, length = 100)
    @Enumerated(EnumType.STRING)
    private AgentRarity agentRarity;

}
