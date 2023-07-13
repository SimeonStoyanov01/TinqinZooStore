package com.example.tinqin.zoostore.API.controller;

import com.example.tinqin.zoostore.API.request.VendorCreateRequest;
import com.example.tinqin.zoostore.API.request.VendorDeleteRequest;
import com.example.tinqin.zoostore.API.request.VendorUpdateNameRequest;
import com.example.tinqin.zoostore.API.request.VendorUpdatePhoneRequest;
import com.example.tinqin.zoostore.API.response.*;
import com.example.tinqin.zoostore.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VendorController {
    private final VendorService vendorService;
    @Autowired
    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @PostMapping("/createVendor")
    public ResponseEntity<VendorCreateResponse> createVendor(VendorCreateRequest vendorCreateRequest){

        return ResponseEntity.ok(vendorService.createVendor(vendorCreateRequest));
    }

    @PutMapping("/updateVendorName/{name}")
    public ResponseEntity<VendorUpdateNameResponse> updateVendorName(@PathVariable String name, @RequestBody VendorUpdateNameRequest vendorUpdateRequest){

        return ResponseEntity.ok(vendorService.updateVendorName(vendorUpdateRequest));
    }
    @PutMapping("/updateVendorPhone/{phoneNumber}")
    public ResponseEntity<VendorUpdatePhoneResponse> updateVendorPhone(@PathVariable String phoneNumber, @RequestBody VendorUpdatePhoneRequest vendorUpdatePhoneRequest){

        return ResponseEntity.ok(vendorService.updateVendorPhoneNumber(vendorUpdatePhoneRequest));
    }

    @GetMapping("/getAllVendors")
    public ResponseEntity<List<VendorGetAllByIdResponse>> getAllVendors(){
        List<VendorGetAllByIdResponse> vendorResponseList = vendorService.getAllVendors();
        return ResponseEntity.ok(vendorResponseList);
    }

    @DeleteMapping("/deleteVendor/{name}")
    public ResponseEntity<VendorDeleteResponse> deleteVendor(@RequestBody VendorDeleteRequest vendorDeleteRequest){
        return ResponseEntity.ok(vendorService.deleteVendor(vendorDeleteRequest));
    }


}
