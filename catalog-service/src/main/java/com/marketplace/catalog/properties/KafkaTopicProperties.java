package com.marketplace.catalog.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.kafka.topics")
public record KafkaTopicProperties(TopicProperties items) {

    public record TopicProperties(
            String name,
            int partitions,
            short replicas,
            int minInSyncReplicas) {}
}
