package com.marketplace.catalog.services;

import com.marketplace.catalog.dto.items.SkinInfo;
import com.marketplace.catalog.models.items.SkinTemplate;
import com.marketplace.catalog.mappers.SkinTemplateMapper;
import com.marketplace.catalog.properties.ItemsConfig;
import com.marketplace.catalog.repositories.SkinTemplateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import tools.jackson.core.JsonParser;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;

@Slf4j
@Service
public class ItemsFileReaderImpl implements ItemsFileReader {

    private final ItemsConfig itemsConfig;

    private final RestClient restClient;

    private final SkinTemplateMapper skinsMapper;

    private final SkinTemplateRepository skinTemplateRepository;

    private final ObjectMapper objectMapper;

    public ItemsFileReaderImpl(ItemsConfig itemsConfig, RestClient restClient, SkinTemplateMapper skinTemplateMapper, SkinTemplateRepository skinTemplateRepository, ObjectMapper objectMapper) {
        this.itemsConfig = itemsConfig;
        this.restClient = restClient;
        this.skinsMapper = skinTemplateMapper;
        this.skinTemplateRepository = skinTemplateRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void readSkinsFile() {
        try (InputStream is = ItemsFileReaderImpl.class.getClassLoader()
                .getResourceAsStream("items/skins.json")) {
            List<SkinInfo> skinInfos = objectMapper.readValue(
                    is,
                    new TypeReference<>() {
                    }
            );

            if (!skinInfos.isEmpty()) {
                skinInfos.forEach(skinInfo -> {
                    SkinTemplate template = skinsMapper.toEntity(skinInfo);
                    if (!skinTemplateRepository.existsSkinTemplateByExternalId(template.getExternalId())) {
                        skinTemplateRepository.save(template);
                    }
                });
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

//    public String getSKinsJson() {
//        return restClient.get()
//                .uri("")
//                .retrieve()
//                .body(new ParameterizedTypeReference<>() {});
//    }
}
