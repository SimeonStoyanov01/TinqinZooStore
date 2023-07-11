package com.example.tinqin.zoostore.data.repository;

import com.example.tinqin.zoostore.data.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TagRepository extends JpaRepository<TagEntity, UUID> {
    //Optional<TagEntity> findAllById(UUID id);
    Optional<TagEntity> findTagEntityByTitle(String title);
    int deleteByTitle(String title);

}
