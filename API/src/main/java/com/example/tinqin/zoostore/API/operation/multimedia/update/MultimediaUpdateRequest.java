package com.example.tinqin.zoostore.API.operation.multimedia.update;

import com.example.tinqin.zoostore.API.base.OperationRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MultimediaUpdateRequest implements OperationRequest {
    private String url;
}
