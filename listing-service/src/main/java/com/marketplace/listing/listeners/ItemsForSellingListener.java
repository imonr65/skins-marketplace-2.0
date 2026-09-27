package com.marketplace.listing.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ItemsForSellingListener {


    @KafkaListener(
            topics = "${app.kafka-topics.skins}",
            groupId = "${spring.kafka.consumer.group-id}",
            containerFactory = "..."
    )
    public void handleSkinsItems(ConsumerRecord<String, SellSkin> record) {
        log.debug("Получено сообщение: {}", record.value());

    }

}
