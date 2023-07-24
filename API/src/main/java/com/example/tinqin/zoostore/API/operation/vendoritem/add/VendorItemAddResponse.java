package com.example.tinqin.zoostore.API.operation.vendoritem.add;

import com.example.tinqin.zoostore.API.base.OperationResponse;
import com.example.tinqin.zoostore.API.operation.item.create.ItemCreateResponse;
import lombok.*;

import java.util.Set;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VendorItemAddResponse implements OperationResponse {
    private UUID vendorId;
    private String title;

    private String phoneNumber;

    private Set<ItemCreateResponse> items;
}
