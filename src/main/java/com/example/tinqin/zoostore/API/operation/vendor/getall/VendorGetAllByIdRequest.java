package com.example.tinqin.zoostore.API.operation.vendor.getall;

import com.example.tinqin.zoostore.API.base.OperationRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Getter
@Setter
public class VendorGetAllByIdRequest implements OperationRequest {
    private UUID uuid;
    private String name;
    private String phoneNumber;

}

