package com.example.tinqin.zoostore.API.operation.multimedia.delete;

import com.example.tinqin.zoostore.API.base.OperationRequest;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class MultimediaDeleteRequest implements OperationRequest {
    private String url;
    //private UUID uuid;
}
