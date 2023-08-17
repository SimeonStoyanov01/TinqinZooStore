package com.example.tinqin.zoostore.persistence.repository;

import com.example.tinqin.zoostore.persistence.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;
@Repository
public interface TagRepository extends JpaRepository<TagEntity, UUID> {
    //Optional<TagEntity> findAllById(UUID id);
    Optional<TagEntity> findTagEntityByTitle(String title);


    int deleteByTitle(String title);
    @Query("SELECT t FROM TagEntity t JOIN t.items i WHERE i.id = :itemId")
    Set<TagEntity> getTagEntitiesByItems(@Param("itemId") UUID itemId);



}
