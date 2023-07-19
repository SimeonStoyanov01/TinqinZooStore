package com.example.tinqin.zoostore.API.operation.vendor.update;

import com.example.tinqin.zoostore.API.base.OperationRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class VendorUpdatePhoneRequest implements OperationRequest {
    private UUID uuid;
    private String phoneNumber;
}
