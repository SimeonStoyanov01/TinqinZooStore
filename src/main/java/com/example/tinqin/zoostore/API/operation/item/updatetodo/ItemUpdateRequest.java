package com.example.tinqin.zoostore.API.operation.item.updatetodo;

import com.example.tinqin.zoostore.API.base.OperationRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemUpdateRequest implements OperationRequest {
    private String title;
}
