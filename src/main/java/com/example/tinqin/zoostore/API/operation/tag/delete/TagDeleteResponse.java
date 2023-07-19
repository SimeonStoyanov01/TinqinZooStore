package com.example.tinqin.zoostore.API.operation.tag.delete;

import com.example.tinqin.zoostore.API.base.OperationResponse;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TagDeleteResponse implements OperationResponse {
    private UUID tagId;
    private String title;
}
