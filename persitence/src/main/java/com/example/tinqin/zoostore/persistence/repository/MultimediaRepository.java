package com.example.tinqin.zoostore.persistence.repository;

import com.example.tinqin.zoostore.persistence.entity.MultimediaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface MultimediaRepository extends JpaRepository<MultimediaEntity, UUID> {

    Optional<MultimediaEntity> findMultimediaEntityByUrl(String url);
    Optional<MultimediaEntity> deleteMultimediaEntityByUrl(String url);

}
