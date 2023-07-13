package com.example.tinqin.zoostore.data.repository;

import com.example.tinqin.zoostore.data.entity.VendorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface VendorRepository extends JpaRepository<VendorEntity, UUID> {

    Optional<VendorEntity> findVendorEntityByName(String name);
    Optional<VendorEntity> deleteVendorEntityByName(String name);
    Optional<VendorEntity> findVendorEntityByPhoneNumber(String phoneNumber);
    //Optional<VendorEntity> updateVendorEntityByPhoneNumber(String oldPhoneNumber, String newPhoneNumber);




}
