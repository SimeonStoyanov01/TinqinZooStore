package com.example.tinqin.zoostore.core.service.vendor;

import com.example.tinqin.zoostore.API.base.OperationProcessor;
import com.example.tinqin.zoostore.API.operation.vendor.update.VendorUpdateNameOperation;
import com.example.tinqin.zoostore.API.operation.vendor.update.VendorUpdateNameRequest;
import com.example.tinqin.zoostore.API.operation.vendor.update.VendorUpdateNameResponse;
import com.example.tinqin.zoostore.core.exceptions.VendorExistsException;
import com.example.tinqin.zoostore.core.exceptions.NoVendorWithSuchIdException;
import com.example.tinqin.zoostore.persistence.entity.VendorEntity;
import com.example.tinqin.zoostore.persistence.repository.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class VendorUpdateNameOperationProcessor implements VendorUpdateNameOperation {
    private final VendorRepository vendorRepository;

    @Override
    @Transactional
    public VendorUpdateNameResponse process(VendorUpdateNameRequest operationRequest) {
        if(operationRequest.getName()==null
                ||operationRequest.getName().trim().equals("")){
            throw new IllegalArgumentException();
        }
        if(this.vendorRepository.findVendorEntityByName(operationRequest.getName()).isPresent()){
            throw new VendorExistsException();
        }
        VendorEntity vendor=vendorRepository.findById(operationRequest.getUuid()).orElseThrow(NoVendorWithSuchIdException::new);
        vendor.setName(operationRequest.getName());
        VendorEntity updatedEntity=vendorRepository.save(vendor);
        VendorUpdateNameResponse updateResponse= VendorUpdateNameResponse
                .builder()
                .uuid(updatedEntity.getId())
                .name(updatedEntity.getName())
                .phoneNumber(updatedEntity.getPhoneNumber())
                .build();
        return updateResponse;    }
}
