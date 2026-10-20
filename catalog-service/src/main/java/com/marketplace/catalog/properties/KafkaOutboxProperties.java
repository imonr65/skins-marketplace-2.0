package com.marketplace.catalog.properties;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties("app.kafka.outbox")
public class KafkaOutboxProperties {

    @NotNull
    @Min(50)
    @Max(500)
    private Integer outboxSendBatchSize;

    @NotNull
    @Min(50)
    @Max(500)
    private Integer outboxDeleteBatchSize;

    @NotNull
    private Long fixedDelayForProcessMessages;

    @NotNull
    private Long fixedDelayForDeleteMessages;

    @NotNull
    @Min(1)
    @Max(100)
    private Integer maxRetryCount;


}
