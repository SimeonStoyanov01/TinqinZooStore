package com.example.tinqin.zoostore.API.controller;

import com.example.tinqin.zoostore.API.request.VendorItemAddRequest;
import com.example.tinqin.zoostore.API.response.VendorItemAddResponse;
import com.example.tinqin.zoostore.service.VendorItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendorItemController {

    private final VendorItemService vendorItemService;
    @Autowired
    public VendorItemController(VendorItemService vendorItemService) {
        this.vendorItemService = vendorItemService;
    }

    @PostMapping("/addItem")
    public ResponseEntity<VendorItemAddResponse> addItem(@RequestBody VendorItemAddRequest vendorItemAddRequest){
        return ResponseEntity.ok(vendorItemService.addItemToVendor(vendorItemAddRequest));
    }
}
