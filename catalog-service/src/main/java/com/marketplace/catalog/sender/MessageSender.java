package com.marketplace.catalog.sender;

import com.marketplace.catalog.models.items.Item;

public interface MessageSender {

    void sendMessage(Item item);
}
