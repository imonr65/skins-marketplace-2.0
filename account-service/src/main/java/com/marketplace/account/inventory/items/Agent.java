package com.marketplace.account.inventory.items;


import com.marketplace.account.inventory.items.enums.AgentRarity;
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

    @Column(nullable = false)
    private String name;

    @Column
    private String imageUrl;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AgentRarity agentRarity;


}


//5) *AgentRarity* - Enum. Хранит в себе **Master**, **Superior**, **Exceptional**, **Distinguished**
//6) *Quality* - хранит в себе *Common*
//7) *ItemType* - будет *Agent*
