package com.example.tinqin.zoostore.API.operation.vendor.create;

import com.example.tinqin.zoostore.API.base.OperationRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendorCreateRequest implements OperationRequest {
    private String name;
    private String phoneNumber;
}
