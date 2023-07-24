package com.example.tinqin.zoostore.rest.controller;

import com.example.tinqin.zoostore.API.operation.vendoritem.add.VendorAddItemOperation;
import com.example.tinqin.zoostore.API.operation.vendoritem.add.VendorItemAddRequest;
import com.example.tinqin.zoostore.API.operation.vendoritem.add.VendorItemAddResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendorItemController {

    private final VendorAddItemOperation vendorItemService;
    @Autowired
    public VendorItemController(VendorAddItemOperation vendorItemService) {
        this.vendorItemService = vendorItemService;
    }

    @PostMapping("/addItem")
    public ResponseEntity<VendorItemAddResponse> addItem(@RequestBody VendorItemAddRequest vendorItemAddRequest){
        return ResponseEntity.ok(vendorItemService.process(vendorItemAddRequest));
    }
}
