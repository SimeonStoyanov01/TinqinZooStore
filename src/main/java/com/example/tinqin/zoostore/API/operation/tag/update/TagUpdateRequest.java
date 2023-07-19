package com.example.tinqin.zoostore.API.operation.tag.update;

import com.example.tinqin.zoostore.API.base.OperationRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class TagUpdateRequest implements OperationRequest {
    private UUID tagId;
    private String title;
}
