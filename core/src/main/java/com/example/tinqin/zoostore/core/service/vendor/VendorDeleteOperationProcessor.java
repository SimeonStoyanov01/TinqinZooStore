package com.example.tinqin.zoostore.core.service.vendor;

import com.example.tinqin.zoostore.API.operation.vendor.delete.VendorDeleteOperation;
import com.example.tinqin.zoostore.API.operation.vendor.delete.VendorDeleteRequest;
import com.example.tinqin.zoostore.API.operation.vendor.delete.VendorDeleteResponse;
import com.example.tinqin.zoostore.core.exceptions.NoVendorWithSuchNameException;
import com.example.tinqin.zoostore.persistence.entity.VendorEntity;
import com.example.tinqin.zoostore.persistence.repository.VendorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VendorDeleteOperationProcessor implements VendorDeleteOperation {
    private final VendorRepository vendorRepository;

    public VendorDeleteOperationProcessor(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    @Override
    @Transactional
    public VendorDeleteResponse process(VendorDeleteRequest operationRequest) {
        if(operationRequest.getName()==null
                ||operationRequest.getName().trim().equals("")){
            throw new IllegalArgumentException();
        }
        VendorEntity vendor = vendorRepository
                .findVendorEntityByName(operationRequest.getName())
                .orElseThrow(NoVendorWithSuchNameException::new);
        vendorRepository.deleteById(vendor.getId());
        return VendorDeleteResponse
                .builder()
                .uuid(vendor.getId())
                .name(vendor.getName())
                .phoneNumber(vendor.getPhoneNumber())
                .build();
    }
}
