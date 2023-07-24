package com.example.tinqin.zoostore.API.operation.multimedia.update;

import com.example.tinqin.zoostore.API.base.OperationResponse;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MultimediaUpdateResponse implements OperationResponse {
    private UUID multimediaID;
    private String url;
}
