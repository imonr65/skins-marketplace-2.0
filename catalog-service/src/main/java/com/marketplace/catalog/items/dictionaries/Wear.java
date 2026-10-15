package com.marketplace.catalog.items.dictionaries;

import com.marketplace.catalog.items.enums.WearType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "wears")
public class Wear {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "wear_type", nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private WearType wearType;

}
