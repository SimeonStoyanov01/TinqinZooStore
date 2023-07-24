package com.example.tinqin.zoostore.API.operation.vendor.getall;

import lombok.*;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class VendorResponse {
    private UUID uuid;
    private String name;
    private String phoneNumber;
}
