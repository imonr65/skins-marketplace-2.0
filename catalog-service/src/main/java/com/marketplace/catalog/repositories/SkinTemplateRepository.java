package com.marketplace.catalog.repositories;

import com.marketplace.catalog.models.items.SkinTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SkinTemplateRepository extends JpaRepository<SkinTemplate, UUID> {

    boolean existsSkinTemplateByExternalId(String uuid);
}
