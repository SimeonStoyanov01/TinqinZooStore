package com.example.tinqin.zoostore.API.request;

import com.example.tinqin.zoostore.data.entity.ItemEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class VendorItemAddRequest {
    private UUID vendorId;
    private UUID itemId;
}
