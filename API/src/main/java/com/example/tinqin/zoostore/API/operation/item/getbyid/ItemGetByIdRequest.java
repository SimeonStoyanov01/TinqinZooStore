package com.example.tinqin.zoostore.API.operation.item.getbyid;

import com.example.tinqin.zoostore.API.base.OperationRequest;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemGetByIdRequest implements OperationRequest {
    private String id;
}
