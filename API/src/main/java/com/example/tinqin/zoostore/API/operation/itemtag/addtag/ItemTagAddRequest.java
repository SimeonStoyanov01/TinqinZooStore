package com.example.tinqin.zoostore.API.operation.itemtag.addtag;

import com.example.tinqin.zoostore.API.base.OperationRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class ItemTagAddRequest implements OperationRequest {
    private UUID tagId;
    private UUID itemId;
}
