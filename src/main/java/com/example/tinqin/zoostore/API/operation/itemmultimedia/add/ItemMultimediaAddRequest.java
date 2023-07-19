package com.example.tinqin.zoostore.API.operation.itemmultimedia.add;

import com.example.tinqin.zoostore.API.base.OperationRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ItemMultimediaAddRequest implements OperationRequest {
    private UUID itemId;
    private UUID multimediaId;
}
