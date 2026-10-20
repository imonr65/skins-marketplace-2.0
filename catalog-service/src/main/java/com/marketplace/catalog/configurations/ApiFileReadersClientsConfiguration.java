package com.marketplace.catalog.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tools.jackson.databind.ObjectMapper;

@Configuration
public class ApiFileReadersClientsConfiguration {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}
