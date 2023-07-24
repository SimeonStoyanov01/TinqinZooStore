package com.example.tinqin.zoostore.core.service.vendor;

import com.example.tinqin.zoostore.API.operation.vendor.create.VendorCreateOperation;
import com.example.tinqin.zoostore.API.operation.vendor.create.VendorCreateRequest;
import com.example.tinqin.zoostore.API.operation.vendor.create.VendorCreateResponse;
import com.example.tinqin.zoostore.core.exceptions.VendorExistsException;
import com.example.tinqin.zoostore.persistence.entity.VendorEntity;
import com.example.tinqin.zoostore.persistence.repository.VendorRepository;
import org.springframework.stereotype.Service;

@Service
public class VendorCreateOperationProcessor implements VendorCreateOperation {
    private final VendorRepository vendorRepository;

    public VendorCreateOperationProcessor(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    @Override
    public VendorCreateResponse process(VendorCreateRequest operationRequest) {
        if(operationRequest.getName()==null
                ||operationRequest.getPhoneNumber()==null
                ||operationRequest.getPhoneNumber().trim().equals("")
                ||operationRequest.getName().trim().equals("")){
            throw new IllegalArgumentException();
        }
        if(this.vendorRepository.findVendorEntityByName(operationRequest.getName()).isPresent()
                ||this.vendorRepository.findVendorEntityByPhoneNumber(operationRequest.getPhoneNumber()).isPresent()){
            throw new VendorExistsException();
        }
        VendorEntity vendor=new VendorEntity();
        vendor.setName(operationRequest.getName());
        vendor.setPhoneNumber(operationRequest.getPhoneNumber());
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
}
