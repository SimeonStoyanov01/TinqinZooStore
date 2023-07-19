package com.example.tinqin.zoostore.API.operation.vendor.delete;

import com.example.tinqin.zoostore.API.base.OperationRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class VendorDeleteRequest implements OperationRequest {
    //private UUID uuid;
    private String name;
    //private String phoneNumber;
}
