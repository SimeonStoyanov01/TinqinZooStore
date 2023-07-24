package com.example.tinqin.zoostore.API.operation.item.deletetodo;

import com.example.tinqin.zoostore.API.base.OperationRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDeleteRequest implements OperationRequest {
    private String title;
}
