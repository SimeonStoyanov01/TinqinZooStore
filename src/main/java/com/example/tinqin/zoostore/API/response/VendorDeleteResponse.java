package com.example.tinqin.zoostore.API.response;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class VendorDeleteResponse {
    private UUID uuid;
    private String name;
    private String phoneNumber;
}
