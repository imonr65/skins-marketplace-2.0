package com.marketplace.catalog.schedulers;

import com.marketplace.catalog.services.ItemsFileReader;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StartupTask {

    private final ItemsFileReader itemsFileReader;

    public StartupTask(ItemsFileReader itemsFileReader) {
        this.itemsFileReader = itemsFileReader;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        itemsFileReader.readSkinsFile();
    }
}


