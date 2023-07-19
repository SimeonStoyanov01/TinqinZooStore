package com.example.tinqin.zoostore.rest.controller;

import com.example.tinqin.zoostore.API.operation.vendor.create.VendorCreateOperation;
import com.example.tinqin.zoostore.API.operation.vendor.create.VendorCreateRequest;
import com.example.tinqin.zoostore.API.operation.vendor.create.VendorCreateResponse;
import com.example.tinqin.zoostore.API.operation.vendor.delete.VendorDeleteOperation;
import com.example.tinqin.zoostore.API.operation.vendor.delete.VendorDeleteRequest;
import com.example.tinqin.zoostore.API.operation.vendor.delete.VendorDeleteResponse;
import com.example.tinqin.zoostore.API.operation.vendor.getall.VendorGetAllByIdRequest;
import com.example.tinqin.zoostore.API.operation.vendor.getall.VendorGetAllOperation;
import com.example.tinqin.zoostore.API.operation.vendor.update.VendorUpdateNameOperation;
import com.example.tinqin.zoostore.API.operation.vendor.update.VendorUpdateNameRequest;
import com.example.tinqin.zoostore.API.operation.vendor.update.VendorUpdateNameResponse;
import com.example.tinqin.zoostore.API.operation.vendor.getall.VendorGetAllByIdResponse;
import com.example.tinqin.zoostore.API.operation.vendor.update.VendorUpdatePhoneOperation;
import com.example.tinqin.zoostore.API.operation.vendor.update.VendorUpdatePhoneRequest;
import com.example.tinqin.zoostore.API.operation.vendor.update.VendorUpdatePhoneResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class VendorController {
    private final VendorCreateOperation createOperation;
    private final VendorUpdateNameOperation updateVendorName;
    private final VendorUpdatePhoneOperation updateVendorPhoneNumber;
    private final VendorDeleteOperation vendorDeleteOperation;
    private final VendorGetAllOperation vendorGetAllOperation;


    @PostMapping("/createVendor")
    public ResponseEntity<VendorCreateResponse> createVendor(VendorCreateRequest vendorCreateRequest){

        return ResponseEntity.ok(createOperation.process(vendorCreateRequest));
    }

    @PutMapping("/updateVendorName")
    public ResponseEntity<VendorUpdateNameResponse> updateVendorName(@RequestBody VendorUpdateNameRequest vendorUpdateRequest){

        return ResponseEntity.ok(updateVendorName.process(vendorUpdateRequest));
    }
    @PutMapping("/updateVendorPhone")
    public ResponseEntity<VendorUpdatePhoneResponse> updateVendorPhone(@RequestBody VendorUpdatePhoneRequest vendorUpdatePhoneRequest){

        return ResponseEntity.ok(updateVendorPhoneNumber.process(vendorUpdatePhoneRequest));
    }

    @GetMapping("/getAllVendors")
    public ResponseEntity <VendorGetAllByIdResponse> getAllVendors(VendorGetAllByIdRequest vendorGetAllByIdRequest){
        VendorGetAllByIdResponse vendorResponseList = vendorGetAllOperation.process(vendorGetAllByIdRequest);
        return ResponseEntity.ok(vendorResponseList);
    }

    @DeleteMapping("/deleteVendor/{name}")
    public ResponseEntity<VendorDeleteResponse> deleteVendor(@RequestBody VendorDeleteRequest vendorDeleteRequest){
        return ResponseEntity.ok(vendorDeleteOperation.process(vendorDeleteRequest));
    }


}
