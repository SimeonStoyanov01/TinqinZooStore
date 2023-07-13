package com.example.tinqin.zoostore.API.request;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class VendorUpdateNameRequest {
    private UUID uuid;
    private String name;
    //private String phoneNumber;
}
