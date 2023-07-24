package com.example.tinqin.zoostore.persistence.repository;

import com.example.tinqin.zoostore.persistence.entity.MultimediaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MultimediaRepository extends JpaRepository<MultimediaEntity, UUID> {

    Optional<MultimediaEntity> findMultimediaEntityByUrl(String url);
    Optional<MultimediaEntity> deleteMultimediaEntityByUrl(String url);
}
