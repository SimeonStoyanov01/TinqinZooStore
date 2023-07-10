package com.example.tinqin.zoostore.repository;

import com.example.tinqin.zoostore.domain.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ItemRepository extends JpaRepository<ItemEntity, UUID> {
    // ... custom query methods if needed
}
