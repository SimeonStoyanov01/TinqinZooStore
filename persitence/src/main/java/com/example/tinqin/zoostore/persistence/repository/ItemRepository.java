package com.example.tinqin.zoostore.persistence.repository;

import com.example.tinqin.zoostore.persistence.entity.ItemEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;
@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, UUID> {

    Optional<ItemEntity> findItemEntityByTitle(String title);

    Page<ItemEntity> findItemEntitiesByTagId(UUID tagId, Pageable pageable);

    @Query(value = """
            SELECT *
            FROM items i
            WHERE i.title REGEXP :regex
            """, nativeQuery = true)
    Page<ItemEntity> findAllByPartialTitle(String regex, Pageable pageable);


    Optional<ItemEntity> findItemEntityById(UUID uuid);

}
