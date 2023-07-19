package com.example.tinqin.zoostore.core.service.vendor;

import com.example.tinqin.zoostore.API.operation.vendor.getall.VendorGetAllByIdRequest;
import com.example.tinqin.zoostore.API.operation.vendor.getall.VendorGetAllByIdResponse;
import com.example.tinqin.zoostore.API.operation.vendor.getall.VendorGetAllOperation;
import com.example.tinqin.zoostore.API.operation.vendor.getall.VendorResponse;
import com.example.tinqin.zoostore.persistence.entity.VendorEntity;
import com.example.tinqin.zoostore.persistence.repository.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VendorGetAllOperationProcessor implements VendorGetAllOperation {
    private final VendorRepository vendorRepository;

    public VendorGetAllOperationProcessor(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }
    //TODO this process to be checked if working
    @Override
    public VendorGetAllByIdResponse process(VendorGetAllByIdRequest operationRequest) {
        List<VendorEntity> vendorEntityList = this.vendorRepository.findAll();
        VendorGetAllByIdResponse getAllByIdResponses=new VendorGetAllByIdResponse();
        //List<VendorGetAllByIdResponse> vendorResponseList = new ArrayList<>();
        for (VendorEntity ve:vendorEntityList
        ) {
            VendorResponse vendorResponse = VendorResponse
                    .builder()
                    .name(ve.getName())
                    .phoneNumber(ve.getPhoneNumber())
                    .uuid(ve.getId())
                    .build();
            getAllByIdResponses.getVendorResponseList().add(vendorResponse);

        }
        return getAllByIdResponses;
    }
}
