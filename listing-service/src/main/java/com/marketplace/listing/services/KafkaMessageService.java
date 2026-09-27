package com.marketplace.listing.services;

import com.marketplace.listing.models.KafkaMessage;

public interface KafkaMessageService {

    KafkaMessage save(KafkaMessage kafkaMessage);
}
