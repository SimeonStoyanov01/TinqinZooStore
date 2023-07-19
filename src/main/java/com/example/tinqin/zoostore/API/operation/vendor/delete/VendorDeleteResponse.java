package com.example.tinqin.zoostore.API.operation.vendor.delete;

import com.example.tinqin.zoostore.API.base.OperationResponse;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class VendorDeleteResponse implements OperationResponse {
    private UUID uuid;
    private String name;
    private String phoneNumber;
}
