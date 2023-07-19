package com.example.tinqin.zoostore.persistence.repository;

import com.example.tinqin.zoostore.persistence.entity.ItemEntity;
import com.example.tinqin.zoostore.persistence.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface ItemRepository extends JpaRepository<ItemEntity, UUID> {
    ItemEntity getByTitle(String title);

    Optional<ItemEntity> findItemEntityByTitle(String title);

}
