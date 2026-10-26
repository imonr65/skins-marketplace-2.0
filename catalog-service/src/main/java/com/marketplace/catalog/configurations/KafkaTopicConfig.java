package com.marketplace.catalog.configurations;

import com.marketplace.catalog.properties.KafkaTopicProperties;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class KafkaTopicConfig {

    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    private final KafkaTopicProperties kafkaTopicProperties;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic itemsTopic() {
        return TopicBuilder.name(kafkaTopicProperties.items().name())
                .partitions(kafkaTopicProperties.items().partitions())
                .replicas(kafkaTopicProperties.items().replicas())
                .config(TopicConfig.MIN_IN_SYNC_REPLICAS_CONFIG, "" + kafkaTopicProperties.items().minInSyncReplicas())
                .build();
    }

    @Bean
    public NewTopic itemsTopicDLQ() {
        return new NewTopic(
                kafkaTopicProperties.items().name() + ".dlq",
                kafkaTopicProperties.items().partitions(),
                kafkaTopicProperties.items().replicas()
        );
    }
}
