package com.example.tinqin.zoostore.data.repository;

import com.example.tinqin.zoostore.data.entity.ItemEntity;
import com.fasterxml.jackson.annotation.OptBoolean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ItemRepository extends JpaRepository<ItemEntity, UUID> {
    ItemEntity getByTitle(String title);

    Optional<ItemEntity> findItemEntityByTitle(String title);
}
