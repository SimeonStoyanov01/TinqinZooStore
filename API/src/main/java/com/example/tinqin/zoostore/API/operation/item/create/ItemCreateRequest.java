package com.example.tinqin.zoostore.API.operation.item.create;

import com.example.tinqin.zoostore.API.base.OperationRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemCreateRequest implements OperationRequest {
    private String title;
}
