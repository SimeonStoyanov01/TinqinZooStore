package com.example.tinqin.zoostore.persistence.repository;

import com.example.tinqin.zoostore.persistence.entity.ItemEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface ItemRepository extends JpaRepository<ItemEntity, UUID> {

    Optional<ItemEntity> findItemEntityByTitle(String title);

    Page<ItemEntity> findItemEntitiesByTagId(UUID tagId, Pageable pageable);


    Optional<ItemEntity> findItemEntityById(UUID uuid);

}
