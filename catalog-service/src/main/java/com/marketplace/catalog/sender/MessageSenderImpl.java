package com.marketplace.catalog.sender;

import com.marketplace.catalog.models.items.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageSenderImpl implements MessageSender {



    @Override
    public void sendMessage(Item item) {
    }
}
