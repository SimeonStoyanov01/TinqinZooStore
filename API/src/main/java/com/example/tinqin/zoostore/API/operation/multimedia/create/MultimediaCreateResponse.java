package com.example.tinqin.zoostore.API.operation.multimedia.create;

import com.example.tinqin.zoostore.API.base.OperationResponse;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MultimediaCreateResponse implements OperationResponse {
    private UUID multimediaID;
    private String url;
    private Boolean is_archived;
}
