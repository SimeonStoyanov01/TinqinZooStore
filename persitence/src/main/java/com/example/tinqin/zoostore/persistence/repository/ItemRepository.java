package com.example.tinqin.zoostore.persistence.repository;

import com.example.tinqin.zoostore.persistence.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ItemRepository extends JpaRepository<ItemEntity, UUID> {

    Optional<ItemEntity> findItemEntityByTitle(String title);

    Optional<ItemEntity> findItemEntityById(UUID uuid);

}
