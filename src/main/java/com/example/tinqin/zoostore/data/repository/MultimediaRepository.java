package com.example.tinqin.zoostore.data.repository;

import com.example.tinqin.zoostore.data.entity.MultimediaEntity;
import com.example.tinqin.zoostore.data.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MultimediaRepository extends JpaRepository<MultimediaEntity, UUID> {

    Optional<MultimediaEntity> findMultimediaEntityByUrl(String url);
    Optional<MultimediaEntity> deleteMultimediaEntityByUrl(String url);
}
