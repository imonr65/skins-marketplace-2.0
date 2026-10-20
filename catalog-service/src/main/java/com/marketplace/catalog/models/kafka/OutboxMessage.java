package com.marketplace.catalog.models.kafka;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutboxMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID externalId;

    private String payload;

    private Integer retryCount;

    private Integer maxRetryCount;

    private ProcessStatus processStatus;

    private OffsetDateTime publishedAt;

    private OffsetDateTime updateAt;

    public void incrementRetryCount() {
        retryCount++;
    }
}
