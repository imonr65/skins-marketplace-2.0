package com.marketplace.listing.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NegativeOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@NegativeOrZero
@AllArgsConstructor
@Entity
public class KafkaMessage {
}
