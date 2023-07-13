package com.example.tinqin.zoostore.API.response;

import com.example.tinqin.zoostore.data.entity.ItemEntity;
import lombok.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VendorItemAddResponse {
    private UUID vendorId;
    private String title;

    private String phoneNumber;

    private Set<ItemCreateResponse> items;
}
