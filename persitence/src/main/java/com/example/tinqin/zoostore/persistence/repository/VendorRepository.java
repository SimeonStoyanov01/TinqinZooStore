package com.example.tinqin.zoostore.persistence.repository;

import com.example.tinqin.zoostore.persistence.entity.VendorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface VendorRepository extends JpaRepository<VendorEntity, UUID> {

    Optional<VendorEntity> findVendorEntityByName(String name);
    Optional<VendorEntity> deleteVendorEntityByName(String name);
    Optional<VendorEntity> findVendorEntityByPhoneNumber(String phoneNumber);
    //Optional<VendorEntity> updateVendorEntityByPhoneNumber(String oldPhoneNumber, String newPhoneNumber);




}
