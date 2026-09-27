package com.marketplace.listing.models;

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
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ListingStatus status;



}

//        | item          | Item          | да           | —                            | Продаваемый товар                                             |
//        | sellerId      | UUID          | да           | —                            | Получаем, когда пользователь выставляет свой товар на продажу |
//        | createdAt     | ISO-8601      | да           | UTC                          | Дата создания объявления                                      |
//        | reservedUntil | ISO-8601      | нет          | UTC                          | Дата то какого момента времени товар зарезервирован           |
//        | price         | Decimial      | да           | больше 0                     | Цена объявления                                               |
