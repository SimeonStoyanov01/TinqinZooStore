package com.example.tinqin.zoostore.API.operation.vendoritem.add;

import com.example.tinqin.zoostore.API.base.OperationRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class VendorItemAddRequest implements OperationRequest {
    private UUID vendorId;
    private UUID itemId;
}
