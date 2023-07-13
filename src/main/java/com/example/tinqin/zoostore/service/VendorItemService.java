package com.example.tinqin.zoostore.service;

import com.example.tinqin.zoostore.API.request.VendorItemAddRequest;
import com.example.tinqin.zoostore.API.response.VendorItemAddResponse;
import com.example.tinqin.zoostore.data.entity.ItemEntity;

import java.util.UUID;

public interface VendorItemService {
    public VendorItemAddResponse addItemToVendor(VendorItemAddRequest vendorItemAddRequest);
    public void removeItemFromVendor(UUID vendorId, UUID itemId);

}
