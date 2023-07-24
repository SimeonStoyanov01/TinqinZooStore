package com.example.tinqin.zoostore.API.operation.multimedia.delete;

import com.example.tinqin.zoostore.API.base.OperationResponse;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MultimediaDeleteResponse implements OperationResponse {

    private UUID multimediaID;
    private String url;
}
