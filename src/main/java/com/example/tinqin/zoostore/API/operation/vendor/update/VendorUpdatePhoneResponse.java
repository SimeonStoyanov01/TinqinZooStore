package com.example.tinqin.zoostore.API.operation.vendor.update;

import com.example.tinqin.zoostore.API.base.OperationResponse;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class VendorUpdatePhoneResponse implements OperationResponse {
    private UUID uuid;
    private String name;
    private String phoneNumber;
}
