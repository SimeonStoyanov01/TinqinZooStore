package com.example.tinqin.zoostore.API.operation.multimedia.create;

import com.example.tinqin.zoostore.API.base.OperationRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MultimediaCreateRequest implements OperationRequest {
    private String url;
}
