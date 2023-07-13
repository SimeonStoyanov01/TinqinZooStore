package com.example.tinqin.zoostore.service.impl;

import com.example.tinqin.zoostore.API.request.*;
import com.example.tinqin.zoostore.API.response.*;
import com.example.tinqin.zoostore.data.entity.VendorEntity;
import com.example.tinqin.zoostore.data.repository.VendorRepository;
import com.example.tinqin.zoostore.exceptions.NoVendorWithSuchIdException;
import com.example.tinqin.zoostore.exceptions.NoVendorWithSuchNameException;
import com.example.tinqin.zoostore.exceptions.VendorExistsException;
import com.example.tinqin.zoostore.service.VendorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {
    private final VendorRepository vendorRepository;

    public VendorServiceImpl(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    @Override
    public VendorCreateResponse createVendor(VendorCreateRequest vendorCreateRequest) {
        if(vendorCreateRequest.getName()==null
                ||vendorCreateRequest.getPhoneNumber()==null
                ||vendorCreateRequest.getPhoneNumber().trim().equals("")
                ||vendorCreateRequest.getName().trim().equals("")){
            throw new IllegalArgumentException();
        }
        if(this.vendorRepository.findVendorEntityByName(vendorCreateRequest.getName()).isPresent()
                ||this.vendorRepository.findVendorEntityByPhoneNumber(vendorCreateRequest.getPhoneNumber()).isPresent()){
            throw new VendorExistsException();
        }
        VendorEntity vendor=new VendorEntity();
        vendor.setName(vendorCreateRequest.getName());
        vendor.setPhoneNumber(vendorCreateRequest.getPhoneNumber());
        vendor.setIsArchived(false);
        vendorRepository.save(vendor);
        VendorCreateResponse createResponse=VendorCreateResponse
                .builder()
                .uuid(vendor.getId())
                .name(vendor.getName())
                .phoneNumber(vendor.getPhoneNumber())
                .build();
        return createResponse;
    }

    @Override
    public VendorUpdateNameResponse updateVendorName(VendorUpdateNameRequest vendorUpdateRequest) {
        if(vendorUpdateRequest.getName()==null
                ||vendorUpdateRequest.getName().trim().equals("")){
            throw new IllegalArgumentException();
        }
        if(this.vendorRepository.findVendorEntityByName(vendorUpdateRequest.getName()).isPresent()){
            throw new VendorExistsException();
        }
        VendorEntity vendor=vendorRepository.findById(vendorUpdateRequest.getUuid()).orElseThrow(NoVendorWithSuchIdException::new);
        vendor.setName(vendorUpdateRequest.getName());
        VendorEntity updatedEntity=vendorRepository.save(vendor);
        VendorUpdateNameResponse updateResponse= VendorUpdateNameResponse
                .builder()
                .uuid(updatedEntity.getId())
                .name(updatedEntity.getName())
                .phoneNumber(updatedEntity.getPhoneNumber())
                .build();
        return updateResponse;
    }

    @Override
    public VendorUpdatePhoneResponse updateVendorPhoneNumber(VendorUpdatePhoneRequest vendorUpdateRequest) {
        if(vendorUpdateRequest.getPhoneNumber()==null
                ||vendorUpdateRequest.getPhoneNumber().trim().equals("")){
            throw new IllegalArgumentException();
        }
        if(this.vendorRepository.findVendorEntityByPhoneNumber(vendorUpdateRequest.getPhoneNumber()).isPresent()){
            throw new VendorExistsException();
        }
        VendorEntity vendor=vendorRepository.findById(vendorUpdateRequest.getUuid()).orElseThrow(NoVendorWithSuchIdException::new);
        vendor.setPhoneNumber(vendorUpdateRequest.getPhoneNumber());
        VendorEntity updatedEntity=vendorRepository.save(vendor);
        VendorUpdatePhoneResponse updateResponse= VendorUpdatePhoneResponse
                .builder()
                .uuid(updatedEntity.getId())
                .name(updatedEntity.getName())
                .phoneNumber(updatedEntity.getPhoneNumber())
                .build();
        return updateResponse;
    }

    @Override
    @Transactional
    public VendorDeleteResponse deleteVendor(VendorDeleteRequest vendorDeleteRequest) {
        if(vendorDeleteRequest.getName()==null
                ||vendorDeleteRequest.getName().trim().equals("")){
            throw new IllegalArgumentException();
        }
        VendorEntity vendor = vendorRepository
                .findVendorEntityByName(vendorDeleteRequest.getName())
                .orElseThrow(NoVendorWithSuchNameException::new);
        vendorRepository.deleteById(vendor.getId());
        VendorDeleteResponse deleteResponse = VendorDeleteResponse
                .builder()
                .uuid(vendor.getId())
                .name(vendor.getName())
                .phoneNumber(vendor.getPhoneNumber())
                .build();
        return deleteResponse;
    }

    @Override
    public List<VendorGetAllByIdResponse> getAllVendors() {
        List<VendorEntity> vendorEntityList = this.vendorRepository.findAll();
        List<VendorGetAllByIdResponse> vendorResponseList = new ArrayList<>();
        for (VendorEntity ve:vendorEntityList
             ) {VendorGetAllByIdResponse vendorGetAllByIdResponse=
                VendorGetAllByIdResponse
                        .builder()
                        .name(ve.getName())
                        .phoneNumber(ve.getPhoneNumber())
                        .uuid(ve.getId())
                .build();
            vendorResponseList.add(vendorGetAllByIdResponse);


        }
        return vendorResponseList;
    }
}
