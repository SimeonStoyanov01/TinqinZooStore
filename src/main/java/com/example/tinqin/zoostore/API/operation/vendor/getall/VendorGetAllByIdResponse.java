package com.example.tinqin.zoostore.API.operation.vendor.getall;

import com.example.tinqin.zoostore.API.base.OperationResponse;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class VendorGetAllByIdResponse implements OperationResponse {

//    private UUID uuid;
//    private String name;
//    private String phoneNumber;
private List<VendorResponse> vendorResponseList=new ArrayList<>();
}
