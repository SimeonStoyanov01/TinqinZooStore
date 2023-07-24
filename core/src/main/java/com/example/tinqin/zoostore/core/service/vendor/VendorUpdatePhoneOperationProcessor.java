package com.example.tinqin.zoostore.core.service.vendor;

import com.example.tinqin.zoostore.API.operation.vendor.update.VendorUpdatePhoneOperation;
import com.example.tinqin.zoostore.API.operation.vendor.update.VendorUpdatePhoneRequest;
import com.example.tinqin.zoostore.API.operation.vendor.update.VendorUpdatePhoneResponse;
import com.example.tinqin.zoostore.core.exceptions.NoVendorWithSuchIdException;
import com.example.tinqin.zoostore.core.exceptions.VendorExistsException;
import com.example.tinqin.zoostore.persistence.entity.VendorEntity;
import com.example.tinqin.zoostore.persistence.repository.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VendorUpdatePhoneOperationProcessor implements VendorUpdatePhoneOperation {

    private final VendorRepository vendorRepository;

    @Override
    public VendorUpdatePhoneResponse process(VendorUpdatePhoneRequest operationRequest) {
        if(operationRequest.getPhoneNumber()==null
                ||operationRequest.getPhoneNumber().trim().equals("")){
            throw new IllegalArgumentException();
        }
        if(this.vendorRepository.findVendorEntityByPhoneNumber(operationRequest.getPhoneNumber()).isPresent()){
            throw new VendorExistsException();
        }
        VendorEntity vendor=vendorRepository.findById(operationRequest.getUuid()).orElseThrow(NoVendorWithSuchIdException::new);
        vendor.setPhoneNumber(operationRequest.getPhoneNumber());
        VendorEntity updatedEntity=vendorRepository.save(vendor);
        return VendorUpdatePhoneResponse
                .builder()
                .uuid(updatedEntity.getId())
                .name(updatedEntity.getName())
                .phoneNumber(updatedEntity.getPhoneNumber())
                .build();

    }
}
